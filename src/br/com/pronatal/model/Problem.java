package br.com.pronatal.model;

import java.io.Serializable;

import br.com.pronatal.utils.ProblemStatus;

public class Problem implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private int id;
    private User user;
    private String title;
    private String category;
    private String description;
    private Marker marker;
    private ProblemStatus problemStatus;
    private int numberOfFollowers;
    private int upVote = 0;
    private int downVote = 0;
    
    
    public Problem() {
        marker = new Marker();
    }

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
