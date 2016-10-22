package entity;

import entity.Books;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-10-19T16:32:52")
@StaticMetamodel(BooksCategory.class)
public class BooksCategory_ { 

    public static volatile SingularAttribute<BooksCategory, String> categoryName;
    public static volatile SingularAttribute<BooksCategory, Integer> categoryId;
    public static volatile ListAttribute<BooksCategory, Books> booksList;

}