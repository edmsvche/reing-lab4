import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.example.GlidedRose;
import org.example.Item;
import org.junit.jupiter.api.Test;

public class GlidedRoseTest {

	@Test
	public void agedBrieQualityIncreasesOverTime() {
		Item[] items = new Item[]{new Item("Aged Brie", 10, 20)};
		GlidedRose app = new GlidedRose(items);
		int days = 2;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(22, items[0].getQuality());
	}

	@Test
	public void qualityDecreasesAfterSellInDate() {
		Item[] items = new Item[]{new Item("Conjured Mana Cake", 3, 6)};
		GlidedRose app = new GlidedRose(items);
		int days = 4;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(1, items[0].getQuality());
	}

	@Test
	public void sulfurasQualityAndSellInRemainConstant() {
		Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 0, 80)};
		GlidedRose app = new GlidedRose(items);
		int days = 2;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(80, items[0].getQuality());
		assertEquals(0, items[0].getSellIn());
	}

	@Test
	public void backstagePassesQualityIncreasesApproachingConcert() {
		Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)};
		GlidedRose app = new GlidedRose(items);
		int days = 6;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(27, items[0].getQuality());
	}

	@Test
	public void qualityDecreasesTwiceForConjuredItems() {
		Item[] items = new Item[]{new Item("Conjured Mana Cake", 3, 6)};
		GlidedRose app = new GlidedRose(items);
		int days = 2;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(4, items[0].getQuality());
	}

	@Test
	public void agedBrieSellInRemainsUnchanged() {
		Item[] items = new Item[]{new Item("Aged Brie", 10, 20)};
		GlidedRose app = new GlidedRose(items);
		app.updateQuality();
		assertEquals(9, items[0].getSellIn());
	}

	@Test
	public void backstagePassesSellInRemainsUnchanged() {
		Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)};
		GlidedRose app = new GlidedRose(items);
		app.updateQuality();
		assertEquals(14, items[0].getSellIn());
	}

	@Test
	public void sulfurasQualityRemainsUnchanged() {
		Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 0, 80)};
		GlidedRose app = new GlidedRose(items);
		app.updateQuality();
		assertEquals(80, items[0].getQuality());
	}

	@Test
	public void conjuredQualityCannotExceedInitialValue() {
		Item[] items = new Item[]{new Item("Conjured Mana Cake", 3, 6)};
		GlidedRose app = new GlidedRose(items);
		app.updateQuality();
		assertTrue(items[0].getQuality() <= 6);
	}

	@Test
	public void agedBrieSellInDecreasesAfterUpdateQuality() {
		Item[] items = new Item[]{new Item("Aged Brie", 10, 20)};
		GlidedRose app = new GlidedRose(items);
		app.updateQuality();
		assertEquals(9, items[0].getSellIn());
	}

	@Test
	public void backstagePassesSellInDecreasesAfterUpdateQuality() {
		Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)};
		GlidedRose app = new GlidedRose(items);
		app.updateQuality();
		assertEquals(14, items[0].getSellIn());
	}

	@Test
	public void conjuredQualityDecreasesTwiceAfterCertainDays() {
		Item[] items = new Item[]{new Item("Conjured Mana Cake", 5, 10)};
		GlidedRose app = new GlidedRose(items);
		int days = 3;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(7, items[0].getQuality());
	}

	@Test
	public void qualityDecreasesAtDifferentRatesForDifferentItems() {
		Item[] items = new Item[]{
			new Item("+5 Dexterity Vest", 10, 20),
			new Item("Conjured Mana Cake", 5, 10),
			new Item("Aged Brie", 10, 20)
		};
		GlidedRose app = new GlidedRose(items);
		int days = 3;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(17, items[0].getQuality());
		assertEquals(7, items[1].getQuality());
		assertEquals(23, items[2].getQuality());
	}

	@Test
	public void backstagePassesQualityBecomesZeroAfterConcert() {
		Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)};
		GlidedRose app = new GlidedRose(items);
		app.updateQuality();
		assertEquals(0, items[0].getQuality());
	}

	@Test
	public void conjuredQualityCannotExceedFifty() {
		Item[] items = new Item[]{new Item("Conjured Mana Cake", 3, 48)};
		GlidedRose app = new GlidedRose(items);
		app.updateQuality();
		assertTrue(items[0].getQuality() <= 50);
	}

	@Test
	public void agedBrieQualityReachesFiftyAfterCertainDays() {
		Item[] items = new Item[]{new Item("Aged Brie", 5, 45)};
		GlidedRose app = new GlidedRose(items);
		int days = 5;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(50, items[0].getQuality());
	}

	@Test
	public void sulfurasQualityRemainsUnchangedAfterAnyUpdates() {
		Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 5, 80)};
		GlidedRose app = new GlidedRose(items);
		int days = 3;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(80, items[0].getQuality());
	}

	@Test
	public void conjuredQualityDecreasesTwiceFasterAfterNegativeSellIn() {
		Item[] items = new Item[]{new Item("Conjured Mana Cake", -1, 10)};
		GlidedRose app = new GlidedRose(items);
		app.updateQuality();
		assertEquals(8, items[0].getQuality());
	}

	@Test
	public void sulfurasQualityAndSellInRemainUnchangedAfterMultipleUpdates() {
		Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 5, 80)};
		GlidedRose app = new GlidedRose(items);
		int days = 5;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(80, items[0].getQuality());
		assertEquals(5, items[0].getSellIn());
	}

	@Test
	public void agedBrieQualityIncreasesByTwoAfterEachUpdateWithNonNegativeSellIn() {
		Item[] items = new Item[]{new Item("Aged Brie", 5, 20)};
		GlidedRose app = new GlidedRose(items);
		app.updateQuality();
		assertEquals(21, items[0].getQuality());
	}

	@Test
	public void conjuredQualityDecreasesByFourAfterEachUpdateWithNegativeSellIn() {
		Item[] items = new Item[]{new Item("Conjured Mana Cake", -1, 10)};
		GlidedRose app = new GlidedRose(items);
		app.updateQuality();
		assertEquals(8, items[0].getQuality());
	}

	@Test
	public void backstagePassesQualityIncreasesByFiveAfterThreeDaysToConcert() {
		Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 3, 20)};
		GlidedRose app = new GlidedRose(items);
		int days = 3;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(29, items[0].getQuality());
	}

	@Test
	public void conjuredQualityDecreasesTwiceFasterAfterSevenUpdates() {
		Item[] items = new Item[]{new Item("Conjured Mana Cake", 5, 10)};
		GlidedRose app = new GlidedRose(items);
		int days = 7;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(1, items[0].getQuality());
	}

	@Test
	public void sulfurasQualityRemainsUnchangedAfterHundredUpdates() {
		Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 5, 80)};
		GlidedRose app = new GlidedRose(items);
		int days = 100;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(80, items[0].getQuality());
	}

	@Test
	public void agedBrieQualityIncreasesByTenAfterEachUpdateWithNegativeSellIn() {
		Item[] items = new Item[]{new Item("Aged Brie", -1, 20)};
		GlidedRose app = new GlidedRose(items);
		app.updateQuality();
		assertEquals(22, items[0].getQuality());
	}

	@Test
	public void conjuredQualityDecreasesByOneAfterEachUpdateWithNonNegativeSellIn() {
		Item[] items = new Item[]{new Item("Conjured Mana Cake", 5, 10)};
		GlidedRose app = new GlidedRose(items);
		app.updateQuality();
		assertEquals(9, items[0].getQuality());
	}

	@Test
	public void backstagePassesQualityIncreasesByThreeAfterTwoDaysToConcert() {
		Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 2, 20)};
		GlidedRose app = new GlidedRose(items);
		int days = 2;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(26, items[0].getQuality());
	}

	@Test
	public void conjuredQualityDecreasesByThreeAfterFiveUpdates() {
		Item[] items = new Item[]{new Item("Conjured Mana Cake", 5, 10)};
		GlidedRose app = new GlidedRose(items);
		int days = 5;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(5, items[0].getQuality());
	}

	@Test
	public void agedBrieQualityIncreasesByOneAfterEachUpdateWithNonNegativeSellIn() {
		Item[] items = new Item[]{new Item("Aged Brie", 5, 20)};
		GlidedRose app = new GlidedRose(items);
		app.updateQuality();
		assertEquals(21, items[0].getQuality());
	}

	@Test
	public void sulfurasQualityRemainsUnchangedAfterFiftyUpdatesWithNegativeSellIn() {
		Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", -5, 80)};
		GlidedRose app = new GlidedRose(items);
		int days = 50;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(80, items[0].getQuality());
	}

	@Test
	public void conjuredQualityDecreasesByFiveAfterThreeUpdatesWithNegativeSellIn() {
		Item[] items = new Item[]{new Item("Conjured Mana Cake", -1, 20)};
		GlidedRose app = new GlidedRose(items);
		int days = 3;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(14, items[0].getQuality());
	}

	@Test
	public void backstagePassesQualityIncreasesByFourAfterOneDayToConcert() {
		Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 1, 20)};
		GlidedRose app = new GlidedRose(items);
		int days = 1;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(23, items[0].getQuality());
	}

	@Test
	public void conjuredQualityDecreasesByTwoAfterEachUpdateWithSellInGreaterThanTen() {
		Item[] items = new Item[]{new Item("Conjured Mana Cake", 15, 10)};
		GlidedRose app = new GlidedRose(items);
		app.updateQuality();
		assertEquals(9, items[0].getQuality());
	}

	@Test
	public void agedBrieQualityIncreasesByThreeAfterEachUpdateWithSellInGreaterThanTwenty() {
		Item[] items = new Item[]{new Item("Aged Brie", 25, 20)};
		GlidedRose app = new GlidedRose(items);
		app.updateQuality();
		assertEquals(21, items[0].getQuality());
	}

	@Test
	public void conjuredQualityDecreasesByOneAfterEachUpdateWithSellInLessThanOrEqualToFive() {
		Item[] items = new Item[]{new Item("Conjured Mana Cake", 5, 10)};
		GlidedRose app = new GlidedRose(items);
		app.updateQuality();
		assertEquals(9, items[0].getQuality());
	}

	@Test
	public void backstagePassesQualityIncreasesBySixAfterTwoDaysToConcert() {
		Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 2, 20)};
		GlidedRose app = new GlidedRose(items);
		int days = 2;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(26, items[0].getQuality());
	}

	@Test
	public void conjuredQualityDecreasesByThreeAfterTwoUpdatesWithNegativeSellIn() {
		Item[] items = new Item[]{new Item("Conjured Mana Cake", -1, 10)};
		GlidedRose app = new GlidedRose(items);
		int days = 2;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(6, items[0].getQuality());
	}

	@Test
	public void agedBrieQualityIncreasesByFourAfterOneDayWithNegativeSellIn() {
		Item[] items = new Item[]{new Item("Aged Brie", -1, 20)};
		GlidedRose app = new GlidedRose(items);
		app.updateQuality();
		assertEquals(22, items[0].getQuality());
	}

	@Test
	public void conjuredQualityDecreasesByOneAfterEachUpdateWithSellInBetweenFiveAndTen() {
		Item[] items = new Item[]{new Item("Conjured Mana Cake", 8, 10)};
		GlidedRose app = new GlidedRose(items);
		app.updateQuality();
		assertEquals(9, items[0].getQuality());
	}

	@Test
	public void sulfurasQualityRemainsUnchangedAfterThousandUpdatesWithNegativeSellIn() {
		Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", -5, 80)};
		GlidedRose app = new GlidedRose(items);
		int days = 1000;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(80, items[0].getQuality());
	}

	@Test
	public void conjuredQualityDecreasesByOneAfterTenUpdatesWithSellInOverFifty() {
		Item[] items = new Item[]{new Item("Conjured Mana Cake", 55, 50)};
		GlidedRose app = new GlidedRose(items);
		int days = 10;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(40, items[0].getQuality());
	}

	@Test
	public void backstagePassesQualityIncreasesByTenFiveDaysToConcert() {
		Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20)};
		GlidedRose app = new GlidedRose(items);
		int days = 5;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(35, items[0].getQuality());
	}

	@Test
	public void conjuredQualityDecreasesByEightAfterEachUpdateWithSellInBetweenTwentyAndFifty() {
		Item[] items = new Item[]{new Item("Conjured Mana Cake", 25, 40)};
		GlidedRose app = new GlidedRose(items);
		app.updateQuality();
		assertEquals(39, items[0].getQuality());
	}

	@Test
	public void agedBrieQualityIncreasesByTenAfterThreeDaysWithNegativeSellIn() {
		Item[] items = new Item[]{new Item("Aged Brie", -3, 30)};
		GlidedRose app = new GlidedRose(items);
		int days = 3;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(36, items[0].getQuality());
	}

	@Test
	public void conjuredQualityDecreasesByFiveAfterTwentyUpdatesWithNegativeSellIn() {
		Item[] items = new Item[]{new Item("Conjured Mana Cake", -1, 30)};
		GlidedRose app = new GlidedRose(items);
		int days = 20;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(0, items[0].getQuality());
	}

	@Test
	public void backstagePassesQualityIncreasesByFifteenOneDayToConcert() {
		Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 1, 20)};
		GlidedRose app = new GlidedRose(items);
		int days = 1;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(23, items[0].getQuality());
	}

	@Test
	public void conjuredQualityDecreasesByTenAfterFiveUpdatesWithSellInLessThanTen() {
		Item[] items = new Item[]{new Item("Conjured Mana Cake", 8, 30)};
		GlidedRose app = new GlidedRose(items);
		int days = 5;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(25, items[0].getQuality());
	}

	@Test
	public void agedBrieQualityIncreasesByTwentyAfterOneDayWithNegativeSellIn() {
		Item[] items = new Item[]{new Item("Aged Brie", -1, 10)};
		GlidedRose app = new GlidedRose(items);
		int days = 1;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(12, items[0].getQuality());
	}

	@Test
	public void conjuredQualityDecreasesByTwentyAfterTenUpdatesWithNegativeSellIn() {
		Item[] items = new Item[]{new Item("Conjured Mana Cake", -5, 50)};
		GlidedRose app = new GlidedRose(items);
		int days = 10;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(30, items[0].getQuality());
	}

	@Test
	public void conjuredQualityDecreasesByTenAfterTenUpdatesWithSellInBetweenNegativeTenAndFive() {
		Item[] items = new Item[]{new Item("Conjured Mana Cake", 0, 50)};
		GlidedRose app = new GlidedRose(items);
		int days = 10;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(30, items[0].getQuality());
	}

	@Test
	public void agedBrieQualityIncreasesByTwentyAfterTwentyDaysWithSellInLessThanNegativeFive() {
		Item[] items = new Item[]{new Item("Aged Brie", -10, 25)};
		GlidedRose app = new GlidedRose(items);
		int days = 20;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(50, items[0].getQuality());
	}

	@Test
	public void backstagePassesQualityIncreasesByOneHundredFiveDaysToConcert() {
		Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10)};
		GlidedRose app = new GlidedRose(items);
		int days = 5;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(25, items[0].getQuality());
	}

	@Test
	public void sulfurasQualityRemainsUnchangedAfterThousandUpdatesWithSellInNegativeFifty() {
		Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", -50, 80)};
		GlidedRose app = new GlidedRose(items);
		int days = 1000;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(80, items[0].getQuality());
	}

	@Test
	public void conjuredQualityDecreasesByFiftyAfterFiftyUpdatesWithSellInGreaterThanHundred() {
		Item[] items = new Item[]{new Item("Conjured Mana Cake", 120, 100)};
		GlidedRose app = new GlidedRose(items);
		int days = 50;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(50, items[0].getQuality());
	}

	@Test
	public void agedBrieQualityIncreasesByTenAfterTenDaysWithSellInLessThanNegativeTwenty() {
		Item[] items = new Item[]{new Item("Aged Brie", -25, 20)};
		GlidedRose app = new GlidedRose(items);
		int days = 10;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(40, items[0].getQuality());
	}

	@Test
	public void backstagePassesQualityIncreasesByTwoTwoDaysToConcert() {
		Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 2, 30)};
		GlidedRose app = new GlidedRose(items);
		int days = 2;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(36, items[0].getQuality());
	}

	@Test
	public void conjuredQualityDecreasesByThirtyAfterThirtyUpdatesWithSellInBetweenNegativeThirtyAndNegativeTen() {
		Item[] items = new Item[]{new Item("Conjured Mana Cake", -20, 60)};
		GlidedRose app = new GlidedRose(items);
		int days = 30;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(0, items[0].getQuality());
	}

	@Test
	public void agedBrieQualityIncreasesByFifteenAfterFifteenDaysWithSellInLessThanNegativeThirty() {
		Item[] items = new Item[]{new Item("Aged Brie", -35, 40)};
		GlidedRose app = new GlidedRose(items);
		int days = 15;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(50, items[0].getQuality());
	}

	@Test
	public void backstagePassesQualityIncreasesByThreeThreeDaysToConcert() {
		Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 3, 20)};
		GlidedRose app = new GlidedRose(items);
		int days = 3;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(29, items[0].getQuality());
	}

	@Test
	public void agedBrieQualityIncreasesByTwentyAfterTwentyDaysWithSellInLessThanNegativeFifteen() {
		Item[] items = new Item[]{new Item("Aged Brie", -10, 30)};
		GlidedRose app = new GlidedRose(items);
		int days = 20;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(50, items[0].getQuality());
	}

	@Test
	public void backstagePassesQualityIncreasesByFortyEightDaysToConcert() {
		Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 8, 20)};
		GlidedRose app = new GlidedRose(items);
		int days = 8;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(41, items[0].getQuality());
	}

	@Test
	public void conjuredQualityDecreasesByThirtyAfterThirtyUpdatesWithSellInGreaterThanNinety() {
		Item[] items = new Item[]{new Item("Conjured Mana Cake", 100, 70)};
		GlidedRose app = new GlidedRose(items);
		int days = 30;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(40, items[0].getQuality());
	}

	@Test
	public void agedBrieQualityIncreasesByTenAfterTenDaysWithSellInLessThanNegativeTen() {
		Item[] items = new Item[]{new Item("Aged Brie", -5, 40)};
		GlidedRose app = new GlidedRose(items);
		int days = 10;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(50, items[0].getQuality());
	}

	@Test
	public void backstagePassesQualityIncreasesByThirtyFiveSevenDaysToConcert() {
		Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 7, 40)};
		GlidedRose app = new GlidedRose(items);
		int days = 7;
		for (int i = 0; i < days; i++) {
			app.updateQuality();
		}
		assertEquals(50, items[0].getQuality());
	}
}
