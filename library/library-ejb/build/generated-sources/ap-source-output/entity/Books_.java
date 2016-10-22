package entity;

import entity.BooksCategory;
import entity.UserBookmark;
import entity.UserLoan;
import entity.UsersComment;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-19T16:32:52")
@StaticMetamodel(Books.class)
public class Books_ { 

    public static volatile SingularAttribute<Books, Boolean> isAvailable;
    public static volatile ListAttribute<Books, UserBookmark> userBookmarkList;
    public static volatile SingularAttribute<Books, String> author;
    public static volatile SingularAttribute<Books, String> isbn;
    public static volatile SingularAttribute<Books, String> publishDate;
    public static volatile SingularAttribute<Books, String> description;
    public static volatile SingularAttribute<Books, String> publisher;
    public static volatile SingularAttribute<Books, String> title;
    public static volatile ListAttribute<Books, UserLoan> userLoanList;
    public static volatile ListAttribute<Books, UsersComment> usersCommentList;
    public static volatile SingularAttribute<Books, BooksCategory> categoryId;
    public static volatile SingularAttribute<Books, Integer> bookId;

}