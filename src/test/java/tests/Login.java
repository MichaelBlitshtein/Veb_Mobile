package tests;

import manage.ConfigurationWiki;
import manage.MyDataProvider;
import model.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.MainScreen;
import screens.ModalLoginScreen;

public class Login extends ConfigurationWiki {

    @Test
    public void login1(){
        User user = User.builder().userName("Galinachrom").password("Michael123$").build();
        boolean isLogged = new MainScreen(driver)
                .clickTheFlowButton()
                .loginClick()
                .fillInLoginForm(user)
                .clickTheFlowButton()
                .isLogged();
        Assert.assertTrue(isLogged);
    }

    @Test
    public void login2(){
        User user = User.builder().userName("Galinachrom").password("Michael123$").build();
        String info= new MainScreen(driver)
                .clickTheFlowButton()
                .loginClick()
                .fillInLoginForm(user)
                .clickTheFlowButton()
                .getInfo();
        Assert.assertEquals(info,"Galinachrom");

    }
    @Test
    public void login3() {
        User user = User.builder().userName("Galinachrom").password("Michael123$").build();
        String infoOut = new MainScreen(driver)
                .clickTheFlowButton()
                .loginClick()
                .fillInLoginForm(user)
                .clickTheFlowButton()
                .getInfoOut();
        Assert.assertEquals(infoOut, "Log out");
    }

    @Test(dataProvider =  "loginData",dataProviderClass = MyDataProvider.class)
    public void  login4(User user){
       // User user = User.builder().userName("Galinachrom").password("Michael123$").build();
        String inf = new MainScreen(driver)
                .clickTheFlowButton()
                .loginClick()
                .fillInLoginForm(user)
                .clickTheFlowButton()
                .logOut()
                .clickTheFlowButton()
                .getInf();
        Assert.assertEquals(inf, "Log in to Wikipedia");

    }


    @Test(dataProvider = "loginDataCsv",dataProviderClass = MyDataProvider.class)
    public void  login5(User user) {
        //User user = User.builder().userName("Galinachrom").password("Michael123$").build();
        String inf = new MainScreen(driver)
                .clickTheFlowButton()
                .loginClick()
                .fillInLoginForm(user)
                .clickTheFlowButton()
                .logOut()
                .clickTheFlowButton()
                .getInf();
        Assert.assertEquals(inf, "Log in to Wikipedia");
    }
    @AfterMethod
    public void postCondition(){
        new ModalLoginScreen(driver)
                .logOut();
    }
}
