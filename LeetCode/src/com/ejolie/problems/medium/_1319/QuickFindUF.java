package com.ejolie.problems.medium._1319;

/******************************************************************************
 *  Compilation:  javac QuickFindUF.java
 *  Execution:  java QuickFindUF < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *  Data files:   https://algs4.cs.princeton.edu/15uf/tinyUF.txt
 *                https://algs4.cs.princeton.edu/15uf/mediumUF.txt
 *                https://algs4.cs.princeton.edu/15uf/largeUF.txt
 *
 *  Quick-find algorithm.
 *
 ******************************************************************************/

/**
 *  The {@code QuickFindUF} class represents a <em>union–find data type</em>
 *  (also known as the <em>disjoint-sets data type</em>).
 *  It supports the classic <em>union</em> and <em>find</em> operations,
 *  along with a <em>count</em> operation that returns the total number
 *  of sets.
 *  <p>
 *  The union-find data type models a collection of sets containing
 *  <em>n</em> elements, with each element in exactly one set.
 *  The elements are named 0 through <em>n</em>–1.
 *  Initially, there are <em>n</em> sets, with each element in its
 *  own set. The <em>cannonical elemement</em> of a set
 *  (also known as the <em>root</em>, <em>identifier</em>,
 *  <em>leader</em>, or <em>set representative</em>)
 *  is one distinguished element in the set. Here is a summary of
 *  the operations:
 *  <ul>
 *  <li><em>find</em>(<em>p</em>) returns the canonical element
 *      of the set containing <em>p</em>. The <em>find</em> operation
 *      returns the same value for two elements if and only if
 *      they are in the same set.
 *  <li><em>union</em>(<em>p</em>, <em>q</em>) merges the set
 *      containing element <em>p</em> with the set containing
 *      element <em>q</em>. That is, if <em>p</em> and <em>q</em>
 *      are in different sets, replace these two sets
 *      with a new set that is the union of the two.
 *  <li><em>count</em>() returns the number of sets.
 *  </ul>
 *  <p>
 *  The canonical element of a set can change only when the set
 *  itself changes during a call to <em>union</em>&mdash;it cannot
 *  change during a call to either <em>find</em> or <em>count</em>.
 *  <p>
 *  This implementation uses <em>quick find</em>.
 *  The constructor takes &Theta;(<em>n</em>) time, where <em>n</em>
 *  is the number of sites.
 *  The <em>find</em>, <em>connected</em>, and <em>count</em>
 *  operations take &Theta;(1) time; the <em>union</em> operation
 *  takes &Theta;(<em>n</em>) time.
 *  <p>
 *  For alternative implementations of the same API, see
 *  {@link UF}, {@link QuickUnionUF}, and {@link WeightedQuickUnionUF}.
 *  For additional documentation, see
 *  <a href="https://algs4.cs.princeton.edu/15uf">Section 1.5</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */

public class QuickFindUF {
    private int[] id;    // id[i] = component identifier of i
    private int count;   // number of components

    /**
     * Initializes an empty union-find data structure with
     * {@code n} elements {@code 0} through {@code n-1}.
     * Initially, each elements is in its own set.
     *
     * @param n the number of elements
     * @throws IllegalArgumentException if {@code n < 0}
     */
    public QuickFindUF(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++)
            id[i] = i;
    }

    /**
     * Returns the number of sets.
     *
     * @return the number of sets (between {@code 1} and {@code n})
     */
    public int count() {
        return count;
    }

    /**
     * Returns the canonical element of the set containing element {@code p}.
     *
     * @param p an element
     * @return the canonical element of the set containing {@code p}
     * @throws IllegalArgumentException unless {@code 0 <= p < n}
     */
    public int find(int p) {
        validate(p);
        return id[p];
    }

    // validate that p is a valid index
    private void validate(int p) {
        int n = id.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
        }
    }

    /**
     * Returns true if the two elements are in the same set.
     *
     * @param p one element
     * @param q the other element
     * @return {@code true} if {@code p} and {@code q} are in the same set;
     * {@code false} otherwise
     * @throws IllegalArgumentException unless
     *                                  both {@code 0 <= p < n} and {@code 0 <= q < n}
     * @deprecated Replace with two calls to {@link #find(int)}.
     */
    @Deprecated
    public boolean connected(int p, int q) {
        validate(p);
        validate(q);
        return id[p] == id[q];
    }

    /**
     * Merges the set containing element {@code p} with the
     * the set containing element {@code q}.
     *
     * @param p one element
     * @param q the other element
     * @throws IllegalArgumentException unless
     *                                  both {@code 0 <= p < n} and {@code 0 <= q < n}
     */
    public void union(int p, int q) {
        validate(p);
        validate(q);
        int pID = id[p];   // needed for correctness
        int qID = id[q];   // to reduce the number of array accesses

        // p and q are already in the same component
        if (pID == qID) return;

        for (int i = 0; i < id.length; i++)
            if (id[i] == pID) id[i] = qID;
        count--;
    }
}
