package com.marjan.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Comments {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "comment")
    private String comment;
    @Basic
    @Column(name = "promotion_id", nullable = false)
    private int promotionId;

    @ManyToOne
    @JoinColumn(name = "promotion_id", referencedColumnName = "id", insertable=false, updatable=false)
    private Promotions promotionsByPromotionId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    public Promotions getPromotionsByPromotionId() {
        return promotionsByPromotionId;
    }

    public void setPromotionsByPromotionId(Promotions promotionsByPromotionId) {
        this.promotionsByPromotionId = promotionsByPromotionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comments comments = (Comments) o;

        if (id != comments.id) return false;
        if (promotionId != comments.promotionId) return false;
        return Objects.equals(comment, comments.comment);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + promotionId;
        return result;
    }
}
