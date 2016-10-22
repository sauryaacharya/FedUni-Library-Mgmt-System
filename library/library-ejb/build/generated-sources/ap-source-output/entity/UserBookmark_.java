package entity;

import entity.Books;
import entity.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-19T16:32:52")
@StaticMetamodel(UserBookmark.class)
public class UserBookmark_ { 

    public static volatile SingularAttribute<UserBookmark, Integer> bookmarkId;
    public static volatile SingularAttribute<UserBookmark, Users> userId;
    public static volatile SingularAttribute<UserBookmark, Books> bookId;

}