/**
 * Lesson 3. Time Complexity
 */
function solution(A) {
    const N = A.length;
    const check = new Array(N + 2).fill(0);
    for (let num of A) {
        check[num] = 1;
    }
    for (let i = 1; i <= N + 1; i++) {
        if (check[i] == 0) {
            return i;
        }
    }
}
