import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class SearchTreeTester {

    public static void main(String[] args) {
        runTests();
    }

    private static void runTests() {
        testEmptyTree();
        testSingleElementTree();
        testMultipleElementTree();
        testDuplicateElements();
        testRemoveElement();
        testMinMaxValues();
        testCountLeaves();
        testClear();
    }

    private static void testEmptyTree() {
        SearchTree<Integer> tree = new SearchTree<>();

        printTestHeader("Empty Tree");

        assert tree.isEmpty() : "Tree should be empty";
        assert tree.getSize() == 0 : "Size should be 0 for an empty tree";

        try {
            tree.smallest();
            System.out.println("smallest() on Empty Tree: Passed (Expected Exception)");
        } catch (IllegalStateException e) {
            System.out.println("smallest() on Empty Tree: Passed (Expected Exception)");
        }

        try {
            tree.largest();
            System.out.println("largest() on Empty Tree: Passed (Expected Exception)");
        } catch (IllegalStateException e) {
            System.out.println("largest() on Empty Tree: Passed (Expected Exception)");
        }

        assert tree.countLeaves() == 0 : "Number of leaves should be 0 for an empty tree";

        System.out.println();
    }

    private static void testSingleElementTree() {
        SearchTree<Integer> tree = new SearchTree<>(42);

        printTestHeader("Single Element Tree");

        assert !tree.isEmpty() : "Tree should not be empty";
        assert tree.getSize() == 1 : "Size should be 1 for a single-element tree";
        assert tree.smallest() == 42 : "Smallest element should be 42";
        assert tree.largest() == 42 : "Largest element should be 42";
        assert tree.countLeaves() == 1 : "Number of leaves should be 1 for a single-element tree";
        assert tree.contains(42) : "Tree should contain the value 42";

        System.out.println();
    }

    private static void testMultipleElementTree() {
        List<Integer> elements = Arrays.asList(50, 30, 70, 20, 40, 60, 80);
        SearchTree<Integer> tree = new SearchTree<>(elements);

        printTestHeader("Multiple Element Tree");

        assert !tree.isEmpty() : "Tree should not be empty";
        assert tree.getSize() == elements.size() : "Size should match the number of elements";

        assert tree.smallest() == 20 : "Smallest element should be 20";
        assert tree.largest() == 80 : "Largest element should be 80";
        assert tree.countLeaves() == 4 : "Number of leaves should be 4";

        for (int element : elements) {
            assert tree.contains(element) : "Tree should contain the value " + element;
        }

        System.out.println();
    }

    private static void testDuplicateElements() {
        List<Integer> elements = Arrays.asList(50, 30, 70, 20, 40, 60, 80, 30, 80);
        SearchTree<Integer> tree = new SearchTree<>(elements);

        printTestHeader("Duplicate Elements");

        assert tree.getSize() == 7 : "Size should exclude duplicate elements";

        assert tree.contains(30) : "Tree should contain the value 30";
        assert tree.contains(80) : "Tree should contain the value 80";

        System.out.println();
    }

    private static void testRemoveElement() {
        List<Integer> elements = Arrays.asList(50, 30, 70, 20, 40, 60, 80);
        SearchTree<Integer> tree = new SearchTree<>(elements);

        printTestHeader("Remove Element");

        assert tree.remove(30) : "Should remove element 30";
        assert tree.getSize() == 6 : "Size should be reduced after removal";

        assert !tree.remove(45) : "Should not remove non-existent element 45";
        assert tree.getSize() == 6 : "Size should remain unchanged";

        assert !tree.contains(30) : "Tree should not contain removed element 30";

        System.out.println();
    }

    private static void testMinMaxValues() {
        List<Integer> elements = Arrays.asList(50, 30, 70, 20, 40, 60, 80);
        SearchTree<Integer> tree = new SearchTree<>(elements);

        printTestHeader("Min and Max Values");

        assert tree.smallest() == 20 : "Smallest element should be 20";
        assert tree.largest() == 80 : "Largest element should be 80";

        System.out.println();
    }

    private static void testCountLeaves() {
        List<Integer> elements = Arrays.asList(50, 30, 70, 20, 40, 60, 80);
        SearchTree<Integer> tree = new SearchTree<>(elements);

        printTestHeader("Count Leaves");

        assert tree.countLeaves() == 4 : "Number of leaves should be 4";

        System.out.println();
    }

    private static void testClear() {
        List<Integer> elements = Arrays.asList(50, 30, 70, 20, 40, 60, 80);
        SearchTree<Integer> tree = new SearchTree<>(elements);

        printTestHeader("Clear Tree");

        assert !tree.isEmpty() : "Tree should not be empty before clear";
        assert tree.getSize() == elements.size() : "Size should match the number of elements before clear";

        tree.clear();

        assert tree.isEmpty() : "Tree should be empty after clear";
        assert tree.getSize() == 0 : "Size should be 0 after clear";

        try {
            tree.smallest();
            System.out.println("smallest() on Cleared Tree: Passed (Expected Exception)");
        } catch (IllegalStateException e) {
            System.out.println("smallest() on Cleared Tree: Passed (Expected Exception)");
        }

        try {
            tree.largest();
            System.out.println("largest() on Cleared Tree: Passed (Expected Exception)");
        } catch (IllegalStateException e) {
            System.out.println("largest() on Cleared Tree: Passed (Expected Exception)");
        }

        assert tree.countLeaves() == 0 : "Number of leaves should be 0 for a cleared tree";

        System.out.println();
    }

    private static void printTestHeader(String testName) {
        System.out.println("=== " + testName + " ===");
    }
}
