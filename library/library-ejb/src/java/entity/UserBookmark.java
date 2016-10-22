/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author saurya
 */
@Entity
@Table(name = "user_bookmark")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserBookmark.findAll", query = "SELECT u FROM UserBookmark u"),
    @NamedQuery(name = "UserBookmark.findByBookmarkId", query = "SELECT u FROM UserBookmark u WHERE u.bookmarkId = :bookmarkId")})
public class UserBookmark implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bookmark_id")
    private Integer bookmarkId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private Users userId;
    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
    @ManyToOne(optional = false)
    private Books bookId;

    public UserBookmark() {
    }

    public UserBookmark(Integer bookmarkId) {
        this.bookmarkId = bookmarkId;
    }

    public Integer getBookmarkId() {
        return bookmarkId;
    }

    public void setBookmarkId(Integer bookmarkId) {
        this.bookmarkId = bookmarkId;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public Books getBookId() {
        return bookId;
    }

    public void setBookId(Books bookId) {
        this.bookId = bookId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookmarkId != null ? bookmarkId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserBookmark)) {
            return false;
        }
        UserBookmark other = (UserBookmark) object;
        if ((this.bookmarkId == null && other.bookmarkId != null) || (this.bookmarkId != null && !this.bookmarkId.equals(other.bookmarkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.UserBookmark[ bookmarkId=" + bookmarkId + " ]";
    }
    
}
