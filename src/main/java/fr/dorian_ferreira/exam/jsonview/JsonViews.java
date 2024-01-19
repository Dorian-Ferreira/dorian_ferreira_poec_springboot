package fr.dorian_ferreira.exam.jsonview;

public interface JsonViews {

    public interface ListingView {}
    public interface ListingShow extends ListingView, UserView {}

    public interface UserView {}
    public interface UserShow extends UserView, ListingView {}
}
