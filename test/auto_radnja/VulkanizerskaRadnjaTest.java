package auto_radnja;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import auto_radnja.VulkanizerskaRadnja;

class VulkanizerskaRadnjaTest extends RadnjaTest{

	@BeforeEach
	void setUp() throws Exception {
		radnja = new VulkanizerskaRadnja();
	}

	@AfterEach
	void tearDown() throws Exception {
		radnja = null;
	}

}
