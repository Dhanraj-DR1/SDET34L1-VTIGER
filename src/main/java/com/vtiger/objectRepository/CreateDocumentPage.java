package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateDocumentPage {
	
	@FindBy(name="notes_title")
	private WebElement titleTxt;

	

	@FindBy(xpath="//html[@dir='ltr']")
	private WebElement descriptionTxtArea;
	

	@FindBy(xpath="//a[@id='cke_5']")
	private WebElement boldIcon;
	

	@FindBy(xpath="//a[@id='cke_6']")
	private WebElement italicICon;
	
	@FindBy(xpath="//input[@id='filename_I__']")
	private WebElement fileUploadBtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savedocumentBtn;
	
	public CreateDocumentPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void enterDocumentTitle(String documentTitle) {
		titleTxt.sendKeys(documentTitle);
	}
		
    public void chooseFile(String filepath) {
    	fileUploadBtn.sendKeys(filepath);
    }
    
    public void saveDocument() {
    	
    	savedocumentBtn.click();
    	}
    
    public void DescriptionEnter(String description) {
    	
    	descriptionTxtArea.sendKeys(description);
    }
    
    public void boldItalicSelect()
    {
    	
    	boldIcon.click();
    	italicICon.click();
    
    }
	
	
	
	
	
	
	
	
	

}
