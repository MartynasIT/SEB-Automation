package com.automation.legoproject.testcases;

import com.automation.framework.loging.Log4jLogger;
import com.automation.framework.utils.ArrayWorker;
import com.automation.legoproject.base.BaseTest;
import com.automation.legoproject.base.PageNavigator;
import com.automation.legoproject.pagecomponents.HeaderMenu;
import com.automation.legoproject.pageobjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class TestSearch extends BaseTest {
    MainPage mainPage;
    HeaderMenu header;
    PageNavigator navigator;
    ProductSearchResultPage searchPage;

    @Test
    public void testSearchAndCart() {
        mainPage = new MainPage(selenium);
        header = new HeaderMenu(selenium);
        navigator = new PageNavigator(selenium);
        LoginPage login = navigator.navigateToLogin();
        login.enterEmail(getEmail());
        login.clickContinue();
        login.enterPassword(getPassword());
        mainPage = login.clickLogin();
        navigator.navigateToCart().deleteItems();
        searchPage = header.enterSearch(getJsonReader().getValue("Search.Item"));
        searchPage = searchPage.selectSort(getJsonReader().getValue("Search.Sort"));
        int[] toAddArray = ArrayWorker.convertStringArrayToArray(getJsonReader().getJsonArray("Add").toJSONString());
        addItemsToCart(toAddArray);
        CartPage cart = navigator.navigateToCart();
        int[] toRemoveArray = ArrayWorker.convertStringArrayToArray(getJsonReader().getJsonArray("Remove").toJSONString());
        cart.deleteItems(findIndexesInSecondArray(toRemoveArray, toAddArray));
        Assert.assertEquals(cart.countItemsInCart(), toAddArray.length - toRemoveArray.length,
                "The amount of items in cart is not correct");
        Log4jLogger.log("Correct amount of products left in cart Verification PASSED");
        String total = cart.getTotal();
        Assert.assertEquals(cart.clickCheckout().getTotal(), total, "Total At checkout should be same as in Cart");
        Log4jLogger.log("Total sum is same as in Cart Verification PASSED");
    }

    public static int[] findIndexesInSecondArray(int[] firstArray, int[] secondArray) {
        int[] indexes = new int[firstArray.length];
        for (int i = 0; i < firstArray.length; i++) {
            int value = firstArray[i];
            indexes[i] = -1;
            for (int j = 0; j < secondArray.length; j++) {
                if (secondArray[j] == value) {
                    indexes[i] = j;
                    break;
                }
            }
        }
        return indexes;
    }

    private void addItemsToCart(int[] arr) {
        for (int i : arr) {
            searchPage.getProduct(i--).click();
            new ProductInfoPage(selenium).addItemToCart();
            for (int j = 0; j < 2; j++)
                selenium.getDriver().navigate().back();
            searchPage = new ProductSearchResultPage(selenium);
        }
    }
}
