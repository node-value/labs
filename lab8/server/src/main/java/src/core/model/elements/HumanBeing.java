package src.core.model.elements;

import java.util.stream.Stream;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.Objects;

import src.util.User;

public class HumanBeing implements Comparable<HumanBeing> {
    private Long              id;
    private String            name;
    private Coordinates       coordinates;
    private ZonedDateTime     creationDate;
    private boolean           realHero;
    private Optional<Boolean> hasToothpick;
    private int               impactSpeed;
    private String            soundtrackName;
    private WeaponType        weaponType;
    private Optional<Mood>    mood;
    private Optional<Car>     car;
    private User              owner;

    public HumanBeing(
        String name, Coordinates coordinates, boolean realHero,
            Boolean hasToothpick, int impactSpeed, String soundtrackName,
                WeaponType weaponType, Mood mood, Car car, User owner) {

        this(null, name, coordinates, ZonedDateTime.now(), realHero,
            hasToothpick, impactSpeed, soundtrackName, weaponType, mood, car, owner);
    }

    public HumanBeing(
        Long id, String name, Coordinates coordinates, ZonedDateTime creationDate,
            boolean realHero, Boolean hasToothpick, int impactSpeed, String soundtrackName,
                    WeaponType weaponType, Mood mood, Car car, User owner) {

        this.id             = id;
        this.name           = Objects.requireNonNull(name);
        this.coordinates    = Objects.requireNonNull(coordinates);
        this.creationDate   = Objects.requireNonNull(creationDate);
        this.realHero       = realHero;
        this.hasToothpick   = Optional.ofNullable(hasToothpick);
        this.impactSpeed    = impactSpeed;
        this.soundtrackName = Objects.requireNonNull(soundtrackName);
        this.weaponType     = Objects.requireNonNull(weaponType);
        this.mood           = Optional.ofNullable(mood);
        this.car            = Optional.ofNullable(car);
        this.owner          = owner;
    }

    public HumanBeing setId(Long id) { this.id = id; return this; }

    public Long getId() { return id; }

    public String getName() { return name; }

    public Coordinates getCoordinates() { return coordinates; }

    public java.time.ZonedDateTime getCreationDate() { return creationDate; }

    public boolean isRealHero() { return realHero; }

    public Optional<Boolean> hasToothpick() { return hasToothpick; }

    public int getImpactSpeed() { return impactSpeed; }

    public String getSoundtrackName() { return soundtrackName; }

    public WeaponType getWeaponType() { return weaponType; }

    public Optional<Mood> getMood() { return mood; }

    public Optional<Car> getCar() { return car; }

    public User getOwner() { return owner; }

    @Override
    public String toString() {
        return "HumanBeing [id=" + id
                + ", name=" + name
                + ", coordinates=" + coordinates.toString()
                + ", creationDate=" + creationDate.toString()
                + ", realHero=" + realHero
                + ", hasToothpick=" + hasToothpick.toString()
                + ", impactSpeed=" + impactSpeed
                + ", soundtrackName=" + soundtrackName
                + ", weaponType=" + weaponType
                + ", mood=" + mood.toString()
                + ", car=" + car.toString() + "]";

    }

    @Override
    public int hashCode() {
        int result = 7;
        result = result * 19 + (int) (id - (id >>> 32));
        result = result * 19 + name.hashCode();
        result = result * 19 + creationDate.hashCode();
        result = result * 19 + coordinates.hashCode();
        result = result * 19 + hasToothpick.hashCode();
        result = result * 19 + (realHero ? 1 : 0);
        result = result * 19 + impactSpeed;
        result = result * 19 + soundtrackName.hashCode();
        result = result * 19 + weaponType.hashCode();
        result = result * 19 + mood.hashCode();
        result = result * 19 + car.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof HumanBeing) {
            HumanBeing other = (HumanBeing) o;
            return Stream.of(
                id == other.getId(), name.equals(other.getName()), coordinates.equals(other.getCoordinates()),
                creationDate.equals(other.getCreationDate()), realHero == other.isRealHero(),
                hasToothpick.equals(other.hasToothpick()), impactSpeed == other.getImpactSpeed(),
                soundtrackName.equals(other.getSoundtrackName()), weaponType.equals(other.getWeaponType()),
                mood.equals(other.getMood()), car.equals(other.getCar())).allMatch(x -> x == true);
        }
        return false;
    }

    @Override
    public int compareTo(HumanBeing human) {
        return Integer.compare(
            coordinates.getX() + coordinates.getY().intValue() + impactSpeed,
                human.getCoordinates().getX() + human.getCoordinates().getY().intValue() + human.getImpactSpeed());
    }
 }

/*
private static long id() {
    long cur = UUID.randomUUID().getMostSignificantBits();
    return cur >= 0 ? cur*2+1 : -(cur*2);
}
 */
