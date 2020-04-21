/**
 * Lesson 2. Arrays
 */
function solution(A) {
    const dict = {};
    for (let i = 0; i < A.length; i++) {
        if (dict.hasOwnProperty(A[i])) {
            dict[A[i]]++;
        } else {
            dict[A[i]] = 1;
        }
    }

    let ans = 0;
    for (let key in dict) {
        if (dict[key] % 2 == 1) {
            ans = key;
            break;
        }
    }
    return +ans;
}
