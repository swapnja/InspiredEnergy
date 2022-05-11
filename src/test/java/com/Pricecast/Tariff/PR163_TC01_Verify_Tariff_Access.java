//verified all tests and modified as per requirement
package com.Pricecast.Tariff;

import com.Pricecast.AbstractTestNg;
import com.Pricecast.PageObjects.Tariffs.Tariff;
import org.testng.annotations.Test;

import java.io.IOException;

public class PR163_TC01_Verify_Tariff_Access extends AbstractTestNg {
	public PR163_TC01_Verify_Tariff_Access() throws IOException {
	}

	//done
	@Test
	public void Tariff_Success() {
		Tariff tariff = new Tariff(webDriverHandler);
		tariff.TariffAccess();
		tariff.TariffColumnVerification();
		tariff.search("British");
	}
//done
	@Test
	public void UploadTariff() {
		Tariff tariff = new Tariff(webDriverHandler);
		tariff.TariffAccess();
		/*
		 * tariff.UploadNewSheet(
		 * "PricecastTestData\\Tariff\\Power\\Ovo Energy-P-.xlsx", "Power", "OVO",
		 * "Acquisition and Renewal", "OVOPower", "19/08/2020", "", "" );
		 */
		tariff.UploadNewSheet(
				"PricecastTestData\\Tariff\\Gas\\Axis-G-Axis 2018 Format.xlsx",
				"Gas",
				"Axis",
				"Acquisition and Renewal",
				"Axis",
				"19/08/2020",
				"",
				""
			);
		}
//done
	@Test ()
	public void reprocessTariff() throws InterruptedException {
		Tariff tariff = new Tariff(webDriverHandler);
		tariff.TariffAccess();
		tariff.reprocessTariff("Power", "Ovo Energy-P-.xlsx");
		tariff.deleteTariff("Ovo Energy-P-.xlsx");
		}
	
	//done
	@Test
	public void deleteTariff() {
		Tariff tariff = new Tariff(webDriverHandler);
		tariff.TariffAccess();
		tariff.UploadNewSheet(
				"PricecastTestData\\Tariff\\Gas\\Axis-G-Axis 2018 Format.xlsx",
				"Gas",
				"Axis",
				"Acquisition and Renewal",
				"Axis",
				"01/02/2020",
				"",
				""
		);
		tariff.deleteTariff("Axis-G-Axis 2018 Format.xlsx");
	}
//done
	@Test
	public void verifyDuplicateUpload() throws InterruptedException {
		Tariff tariff = new Tariff(webDriverHandler);
		tariff.TariffAccess();
		tariff.DuplicateUpload(
				"PricecastTestData\\Tariff\\Gas\\Dyce Energy-G-.xlsx",
				"Gas",
				"DYCE",
				"Renewal Only",
				"DyceGas",
				"01/02/2020",
				"",
				""
		);
		tariff.deleteTariff("Dyce Energy-G-.xlsx");
	}
}