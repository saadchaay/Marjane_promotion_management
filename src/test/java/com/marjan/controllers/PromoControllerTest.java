package com.marjan.controllers;

import com.marjan.dao.PromotionsDao;
import com.marjan.entities.Categories;
import com.marjan.entities.Promotions;
import com.marjan.helpers.EnumValues;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class PromoControllerTest {

    Promotions prm = new Promotions();

    public PromoControllerTest() {
        prm.setCategoryId(2);
        prm.setValue(20);
//        prm.setStatus(EnumValues.status.PENDING.toString());
        prm.setTypeId(EnumValues.idType.CATEGORY.toString());
        prm.setStartDate(Date.valueOf(LocalDate.now()));
        prm.setEndDate(Date.valueOf(LocalDate.now().plusDays(10)));
        prm.setStoreId(3);
    }

    @Test
    void listPromotionByStore(){
        assertNotNull(PromoController.listPromotions(3L));
    }

    // check if there's any promotion with no pending status
    @Test
    void listPendingPromotionByStore(){
        var listPromo = Objects.requireNonNull(PromoController.listPendingPromotions(2L));
        for (Promotions promo: listPromo)
            assertEquals(EnumValues.status.PENDING.toString(), promo.getStatus());
    }

    // add promo with value less than 20, and multimedia category
    @Test
    void addPromotionNormalCase(){
        prm.setCategoryId(3);
        prm.setValue(25);
        assertTrue(PromoController.addPromotion(prm));
    }
    // add promo with value less than 20, and multimedia category
    @Test
    void addPromoWithMediaCategory(){
        prm.setCategoryId(1);
        prm.setValue(15);
        assertTrue(PromoController.addPromotion(prm));
    }

    // add promotion with sup category and set The value of the category
    @Test
    void addPromoWithSupCategory(){
        prm.setTypeId(EnumValues.idType.SUP_CATEGORY.toString());
        prm.setSupCateId(1);
        prm.setValue(10);
        prm.setLoyaltyValue(50);
        assertTrue(PromoController.addPromotion(prm));
    }

    @Test
    void acceptPromotionByAddingComment(){
        assertNotNull(PromoController.acceptPromotion(22L,
                "accept this promotion cuz we have more than 60 unites in the stock"));
    }

    @Test
    void refusePromotion(){
        assertTrue(PromoController.refusePromotion(20L));
    }

}