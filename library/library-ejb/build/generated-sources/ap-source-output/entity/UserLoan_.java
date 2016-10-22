package entity;

import entity.Books;
import entity.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-19T16:32:52")
@StaticMetamodel(UserLoan.class)
public class UserLoan_ { 

    public static volatile SingularAttribute<UserLoan, Date> dueDate;
    public static volatile SingularAttribute<UserLoan, Users> userId;
    public static volatile SingularAttribute<UserLoan, Integer> loanId;
    public static volatile SingularAttribute<UserLoan, Books> bookId;

}