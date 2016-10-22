package entity;

import entity.UserBookmark;
import entity.UserLoan;
import entity.UsersComment;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-19T16:32:52")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> firstName;
    public static volatile SingularAttribute<Users, String> lastName;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile ListAttribute<Users, UserBookmark> userBookmarkList;
    public static volatile SingularAttribute<Users, String> phone;
    public static volatile SingularAttribute<Users, String> middleName;
    public static volatile SingularAttribute<Users, Boolean> isAdmin;
    public static volatile ListAttribute<Users, UserLoan> userLoanList;
    public static volatile ListAttribute<Users, UsersComment> usersCommentList;
    public static volatile SingularAttribute<Users, Integer> userId;
    public static volatile SingularAttribute<Users, String> email;

}