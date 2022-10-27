package com.marjan.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
public class Promotions {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "value")
    private int value;
    @Basic
    @Column(name = "loyalty_value")
    private int loyaltyValue;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "start_date")
    private Date startDate;
    @Basic
    @Column(name = "end_date")
    private Date endDate;
    @Basic
    @Column(name = "type_id")
    private String typeId;
    @Basic
    @Column(name = "sup_cate_id")
    private Integer supCateId;
    @Basic
    @Column(name = "category_id", nullable = false)
    private int categoryId;
    @Basic
    @Column(name = "store_id", nullable = false)
    private int storeId;
    @ManyToOne
    @JoinColumn(name = "sup_cate_id", referencedColumnName = "id", insertable=false, updatable=false)
    private SupCategories supCategoriesBySupCategoryId;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", insertable=false, updatable=false)
    private Categories categoriesByCategoryId;
    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "id", insertable=false, updatable=false)
    private Stores storesByStoreId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getLoyaltyValue() {
        return loyaltyValue;
    }

    public void setLoyaltyValue(int loyaltyValue) {
        this.loyaltyValue = loyaltyValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public int getSupCateId() {
        return supCateId;
    }

    public void setSupCateId(int supCateId) {
        this.supCateId = supCateId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public SupCategories getSupCategoriesBySupCategoryId() {
        return supCategoriesBySupCategoryId;
    }

    public void setSupCategoriesBySupCategoryId(SupCategories supCategoriesBySupCategoryId) {
        this.supCategoriesBySupCategoryId = supCategoriesBySupCategoryId;
    }

    public Categories getCategoriesByCategoryId() {
        return categoriesByCategoryId;
    }

    public void setCategoriesByCategoryId(Categories categoriesByCategoryId) {
        this.categoriesByCategoryId = categoriesByCategoryId;
    }

    public Stores getStoresByStoreId() {
        return storesByStoreId;
    }

    public void setStoresByStoreId(Stores storesByStoreId) {
        this.storesByStoreId = storesByStoreId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Promotions that = (Promotions) o;

        if (id != that.id) return false;
        if (value != that.value) return false;
        if (loyaltyValue != that.loyaltyValue) return false;
        if (categoryId != that.categoryId) return false;
        if (!Objects.equals(status, that.status)) return false;
        if (!Objects.equals(startDate, that.startDate)) return false;
        if (!Objects.equals(endDate, that.endDate)) return false;
        if (!Objects.equals(typeId, that.typeId)) return false;
        return Objects.equals(supCateId, that.supCateId);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + value;
        result = 31 * result + loyaltyValue;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (typeId != null ? typeId.hashCode() : 0);
        result = 31 * result + (supCateId != null ? supCateId.hashCode() : 0);
        result = 31 * result + categoryId;
        return result;
    }
}
