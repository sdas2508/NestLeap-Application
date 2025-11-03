package com.souvik.nestleapapplication.entity;

public class PropertyDetails {

    private Long id;
    private String name;
    private String location;
    private String price; 
    private String size;
    private String type;
    private Double rating;
    private String availability;
    private String image;
    private String description;

    private String[] amenities;
    private String[] nearestLocations;

    public PropertyDetails() {}

    public PropertyDetails(Long id, String name, String location, String price, String size, String type,
                           Double rating, String availability, String image, String description,
                           String[] amenities, String[] nearestLocations) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.price = price;
        this.size = size;
        this.type = type;
        this.rating = rating;
        this.availability = availability;
        this.image = image;
        this.description = description;
        this.amenities = amenities;
        this.nearestLocations = nearestLocations;
    }

    // ✅ Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }

    public String getAvailability() { return availability; }
    public void setAvailability(String availability) { this.availability = availability; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String[] getAmenities() { return amenities; }
    public void setAmenities(String[] amenities) { this.amenities = amenities; }

    public String[] getNearestLocations() { return nearestLocations; }
    public void setNearestLocations(String[] nearestLocations) { this.nearestLocations = nearestLocations; }
}
