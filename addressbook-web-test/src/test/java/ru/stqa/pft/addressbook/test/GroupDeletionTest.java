package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupDeletionTest extends TestBase {
    @Test
    public void testGroupDeletion(){
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("test",null,null));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteGroup();
    }


}
