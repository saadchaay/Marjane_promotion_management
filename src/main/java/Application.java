
import com.marjan.controllers.AuthController;
import com.marjan.controllers.PromoController;
import com.marjan.controllers.UsersController;
import com.marjan.dao.AdminDao;
import com.marjan.dao.CategoriesDao;
import com.marjan.dao.PromotionsDao;
import com.marjan.entities.Comments;
import com.marjan.entities.Promotions;
import com.marjan.entities.SupAdmin;
import com.marjan.helpers.EnumValues;
import com.marjan.helpers.Hash;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        System.out.println(Objects.requireNonNull(PromoController.listPromotions(3L)).get(0).getId());
    }
}
