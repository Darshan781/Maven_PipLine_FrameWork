package com.demoapps.BrowserManager;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserOptions {
	
	//Headless and incognito
	
	public static ChromeOptions getchrChromeOptions(Boolean headless, Boolean incognito) {
		ChromeOptions copts = new ChromeOptions();
		if(headless) {
			copts.addArguments("--headless");
		}
		if(incognito) {
			copts.addArguments("--incognito");
		}
		return copts;
	}
	
	public static FirefoxOptions getFirefoxOptions(Boolean headless, Boolean incognito) {
		FirefoxOptions fopts = new FirefoxOptions();
		if(headless) {
			fopts.addArguments("--headless");
		}
		if(incognito) {
			fopts.addArguments("--private");
		}
		return fopts;
	}
	
	public static  EdgeOptions getEdgeOptions(Boolean headless, Boolean incognito) {
		EdgeOptions eopts = new EdgeOptions();
		if(headless) {
			eopts.addArguments("--headless");
		}
		if(incognito) {
			eopts.addArguments("--inprivate");
		}
		return eopts;
	}
	
}
