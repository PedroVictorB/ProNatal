package br.com.pronatal.model;

import java.io.Serializable;

import br.com.pronatal.utils.ProblemStatus;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "problem")
public class Problem implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @OneToOne
    private User user;
    
    @Column(name = "title", nullable = false, length = 50)
    private String title;
    
    @Column(name = "category", nullable = false, length = 30)
    private String category;
    
    @Column(name = "description", nullable = false, length = 300)
    private String description;
    
    @Column(name = "number_of_followers")
    private int numberOfFollowers;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Marker marker = new Marker();
    
    @Column(name = "date", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date = new Date();
    
    @Column(name = "up_vote")
    private int upVote;
    
    @Column(name = "down_vote")
    private int downVote;
    
    @Enumerated(EnumType.STRING)
    private ProblemStatus problemStatus;

    public int getId() {
            return id;
    }

    public void setId(int id) {
            this.id = id;
    }
    
    public User getUser() {
            return user;
    }

    public void setUser(User user) {
            this.user = user;
    }

    public String getTitle() {
            return title;
    }

    public void setTitle(String title) {
            this.title = title;
    }

    public String getCategory() {
            return category;
    }

    public void setCategory(String category) {
            this.category = category;
    }

    public String getDescription() {
            return description;
    }

    public void setDescription(String description) {
            this.description = description;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public Marker getMarker() {
        return marker;
    }
    
    public void setMarker(Marker marker) {
        this.marker = marker;
    }

    public int getNumberOfFollowers() {
            return numberOfFollowers;
    }

    public void setNumberOfFollowers(int numberOfFollowers) {
            this.numberOfFollowers = numberOfFollowers;
    }

    public ProblemStatus getProblemStatus() {
            return problemStatus;
    }

    public void setProblemStatus(ProblemStatus problemStatus) {
            this.problemStatus = problemStatus;
    }

    /**
     * @return the upVote
     */
    public int getUpVote() {
        return upVote;
    }

    /**
     * @param upVote the upVote to set
     */
    public void setUpVote(int upVote) {
        this.upVote = upVote;
    }

    /**
     * @return the downVote
     */
    public int getDownVote() {
        return downVote;
    }

    /**
     * @param downVote the downVote to set
     */
    public void setDownVote(int downVote) {
        this.downVote = downVote;
    }
}
