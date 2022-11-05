public interface OurComparable {

    /**
     * Return negative number if this < rhs
     * Return 0 if this equals to rhs.
     * Return positive number if this > rhs.
     */
    public int compareTo(Object rhs);
}
