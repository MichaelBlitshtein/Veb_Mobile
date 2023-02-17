package tests;

import manage.ConfigurationWiki;
import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.MainScreen;

public class Login extends ConfigurationWiki {

    @Test
    public void login1(){
        User user = User.builder().userName("Galinachrom").password("Misha240613").build();
        boolean isLogged = new MainScreen(driver)
                .clickTheFlowButton()
                .clickTheLoginButton()
                .fillInLoginForm(user)
                .clickTheFlowButton()
                .isLogged();
        Assert.assertTrue(isLogged);
    }

    @Test
    public void login2(){
        User user = User.builder().userName("Galinachrom").password("Misha240613").build();
        String info= new MainScreen(driver)
                .clickTheFlowButton()
                .clickTheLoginButton()
                .fillInLoginForm(user)
                .clickTheFlowButton()
                .getInfo();
        Assert.assertEquals(info,"Galinachrom");

    }
    @Test
    public void login3() {
        User user = User.builder().userName("Galinachrom").password("Misha240613").build();
        String infoOut = new MainScreen(driver)
                .clickTheFlowButton()
                .clickTheLoginButton()
                .fillInLoginForm(user)
                .clickTheFlowButton()
                .getInfoOut();
        Assert.assertEquals(infoOut, "Log out");
    }

    @Test
    public void  login4(){
        User user = User.builder().userName("Galinachrom").password("Misha240613").build();
        String inf = new MainScreen(driver)
                .clickTheFlowButton()
                .clickTheLoginButton()
                .fillInLoginForm(user)
                .clickTheFlowButton()
                .logOut()
                .clickTheFlowButton()
                .getInf();
        Assert.assertEquals(inf, "Log in to Wikipedia");

    }
}
