package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.StaticWait;
import org.hamcrest.Matchers;
import org.junit.Assert;
import pages.CartPage;
import pages.HomeFalabella;
import pages.ProductDetailPage;
import pages.ProductsPage;
import webdrivermanager.Hook;

public class CartSteps {

    private HomeFalabella homeFalabella = new HomeFalabella(Hook.getWebDriver());
    private ProductsPage productsPage;
    private CartPage cartPage;
    private ProductDetailPage productDetailPage;
    
    @When("^The user looks for \"([^\"]*)\"  in the search bar$")
    public void theUserLooksForInTheSearchBar(String query) throws Throwable {

        productsPage= homeFalabella.searchProduct(query);
    }

    @And("^The user selects any displayed result to add to the shopping cart$")
    public void theUserSelectsAnyDisplayedResultToAddToTheShoppingCart() {
        productDetailPage = productsPage.getProduct();
    }

    @And("^The user adds the product to its shopping cart$")
    public void theUserAddsTheProductToItsShoppingCart() {
        productDetailPage.getProductDetail();
        
    }

    @Then("^The user is informed that the product was added to the cart$")
    public void theUserIsInformedThatTheProductWasAddedToTheCart() {
        String responseExpected = "Producto(s) agregado(s) a la bolsa de compras";
        String response = productDetailPage.getLabelSuccess();
        Assert.assertEquals("El producto no fue añadido al carrito",responseExpected,response);
    }


    @And("^The user delete the product of the shopping cart$")
    public void theUserDeleteTheProductOfTheShoppingCart() {
        cartPage = productDetailPage.goToCartSummary();
        cartPage.deleteLink();
    }

    @Then("^The user is informed that its shopping cart is empty$")
    public void theUserIsInformedThatItsShoppingCartIsEmpty() {
        Boolean deleteResponse = cartPage.getLabelEmpty();
        Assert.assertThat("No sé puedo eliminar el item", deleteResponse, Matchers.equalTo(true));
    }
}
