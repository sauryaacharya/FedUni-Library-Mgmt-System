package entity;

import entity.Books;
import entity.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-19T16:32:52")
@StaticMetamodel(UsersComment.class)
public class UsersComment_ { 

    public static volatile SingularAttribute<UsersComment, Integer> commentId;
    public static volatile SingularAttribute<UsersComment, String> comment;
    public static volatile SingularAttribute<UsersComment, Date> time;
    public static volatile SingularAttribute<UsersComment, Users> userId;
    public static volatile SingularAttribute<UsersComment, Books> bookId;

}