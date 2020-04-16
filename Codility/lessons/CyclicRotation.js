/**
 * Lesson 2. Arrays
 */
function solution(A, K) {
    const len = A.length;
    const arr = new Array(len).fill(0);
    for (let i = 0; i < len; i++) {
        const idx = (i + K) % len;
        arr[idx] = A[i];
    }
    return arr;
}
