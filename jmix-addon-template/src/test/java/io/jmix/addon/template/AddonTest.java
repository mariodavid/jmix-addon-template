package io.jmix.addon.template;

import io.jmix.addon.template.test_support.entity.Foo;
import io.jmix.core.DataManager;
import io.jmix.core.Id;
import io.jmix.core.JmixModuleDescriptor;
import io.jmix.core.JmixModules;
import io.jmix.core.UnconstrainedDataManager;
import io.jmix.core.security.SystemAuthenticator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddonTest {

    @Autowired
    UnconstrainedDataManager dataManager;
    @Autowired
    SystemAuthenticator systemAuthenticator;
    @Autowired
    JmixModules jmixModules;

    @Test
    void contextLoads() {
    }

    @Test
    void testFoo() {

        systemAuthenticator.withSystem(() -> {
            Foo foo = dataManager.create(Foo.class);
            foo.setName("abc");

            Foo foo1 = dataManager.save(foo);
            assertEquals(foo, foo1);

            Foo foo2 = dataManager.load(Id.of(foo)).one();
            assertEquals(foo, foo2);

            return "Done";
        });


    }

    /**
     * currently is working, but it should actually failing, since the addon modules should come last
     */
    @Test
    void wrongOrderOfJmixModules() {

        assertThat(jmixModules.getAll().stream().map(JmixModuleDescriptor::getId))
				.containsExactly(
                        "io.jmix.core",
                        "io.jmix.data",
                        "io.jmix.eclipselink",
                        "io.jmix.ui",
                        "io.jmix.security",
                        "io.jmix.securitydata",

                        "io.jmix.addon.template",
                        "io.jmix.addon.template.test"
                );
    }

    /**
     * currently fails although it should work.
     */
    @Test
    void correctOrderOfJmixModules() {

        assertThat(jmixModules.getAll().stream().map(JmixModuleDescriptor::getId))
				.containsExactly(
                        "io.jmix.core",
                        "io.jmix.data",
                        "io.jmix.eclipselink",
                        "io.jmix.ui",
                        "io.jmix.security",
                        "io.jmix.securitydata",

                        // those should be the last items in the list
                        "io.jmix.addon.template",
                        "io.jmix.addon.template.test"
                );
    }
}
