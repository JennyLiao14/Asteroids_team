public interface Collideable {

    /**
     * Checks if this object is colliding with another Collideable object.
     * @return true if there is a collision, false otherwise.
     */
    boolean isColliding(Collideable other);

    /**
     * Defines the type of collision that has occurred.
     *
     * @return The type of collision as an integer (e.g., 1 for bullet-asteroid collision).
     */
    int getCollisionType(Collideable other);

    /**
     * Handles the collision based on the collision type.
     */
    void handleCollision(int collisionType);

    /**
     * Gets the position of this Collideable object.
     *
     * @return The position of the object as a PVector.
     */
    PVector getPosition();

    /**
     * Gets the radius of this Collideable object for collision detection.
     * This can be used for circular collision detection.
     *
     * @return The radius of the object.
     */
    double getCollisionRadius();
}