/**
 * Lesson 3. Time Complexity
 */
function solution(A) {
    let left = 0;
    let right = A.reduce((a, b) => a + b, 0);
    let minDiff = Number.MAX_VALUE;

    for (let i = 0; i < A.length - 1; i++) {
        left += A[i];
        right -= A[i];
        let diff = Math.abs(left - right);

        if (diff < minDiff) {
            minDiff = diff;
        }
    }

    return minDiff;
}
