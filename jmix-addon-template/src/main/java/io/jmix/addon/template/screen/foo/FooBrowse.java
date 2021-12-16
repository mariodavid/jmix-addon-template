package io.jmix.addon.template.screen.foo;

import io.jmix.addon.template.entity.Foo;
import io.jmix.ui.navigation.Route;
import io.jmix.ui.screen.*;

@UiController("addon_Foo.browse")
@UiDescriptor("foo-browse.xml")
@LookupComponent("foosTable")
@Route("foos")
public class FooBrowse extends StandardLookup<Foo> {
}