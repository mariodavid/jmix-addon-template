package io.jmix.addon.template;

import io.jmix.addon.template.test_support.entity.Foo;
import io.jmix.core.DataManager;
import io.jmix.core.Id;
import io.jmix.core.UnconstrainedDataManager;
import io.jmix.core.security.SystemAuthenticator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddonTest {

	@Autowired
	UnconstrainedDataManager dataManager;
	@Autowired
	SystemAuthenticator systemAuthenticator;

	@Test
	void contextLoads() {
	}

	@Test
	void testFoo() {

		systemAuthenticator.withSystem(() ->  {
			Foo foo = dataManager.create(Foo.class);
			foo.setName("abc");

			Foo foo1 = dataManager.save(foo);
			assertEquals(foo, foo1);

			Foo foo2 = dataManager.load(Id.of(foo)).one();
			assertEquals(foo, foo2);

			return "Done";
		});


	}
}
