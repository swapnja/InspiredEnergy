package com.Pricecast.Tariff;

import com.Pricecast.AbstractTestNg;
import com.Pricecast.PageObjects.Tariffs.Tariff;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR163_TC01_Verify_Tariff_Access extends AbstractTestNg {
	public PR163_TC01_Verify_Tariff_Access() throws IOException {
	}

	@Test
	public void Tariff_Success() {
		Tariff tariff = new Tariff(webDriverHandler);
		tariff.TariffAccess();
		tariff.TariffColumnVerification();
		tariff.search("British");
	}

	@Test
	public void UploadTariff() {
		Tariff tariff = new Tariff(webDriverHandler);
		tariff.TariffAccess();
		tariff.UploadNewSheet(
				"PricecastTestData\\Tariff\\Power\\Ovo Energy-P-.xlsx",
				"Power",
				"Ovo Energy",
				"Acquisition and Renewal",
				"OVOPower",
				"19/08/2020",
				"",
				""
			);
		}

	@Test ()
	public void reprocessTariff() {
		Tariff tariff = new Tariff(webDriverHandler);
		tariff.TariffAccess();
		tariff.reprocessTariff("Power", "Ovo Energy-P-.xlsx");
		tariff.deleteTariff("Ovo Energy-P-.xlsx");
		}

	@Test
	public void deleteTariff() {
		Tariff tariff = new Tariff(webDriverHandler);
		tariff.TariffAccess();
		tariff.UploadNewSheet(
				"PricecastTestData\\Tariff\\Gas\\BES-G-.xlsx",
				"Gas",
				"BES",
				"COT Only",
				"BESGas",
				"01/02/2020",
				"",
				""
		);
		tariff.deleteTariff("BES-G-.xlsx");
	}

	@Test
	public void verifyDuplicateUpload() throws InterruptedException {
		Tariff tariff = new Tariff(webDriverHandler);
		tariff.TariffAccess();
		tariff.DuplicateUpload(
				"PricecastTestData\\Tariff\\Gas\\Dyce Energy-G-.xlsx",
				"Gas",
				"Dyce Energy",
				"Renewal Only",
				"DyceGas",
				"01/02/2020",
				"",
				""
		);
		tariff.deleteTariff("Dyce Energy-G-.xlsx");
	}
}