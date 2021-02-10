/**
 * Lesson 1. Iterations
 */
function solution(N) {
    const str = N.toString(2);
    let max = 0;
    let cnt = 0;
    for (let i = 0; i < str.length; i++) {
        if (str.charAt(i) == "1") {
            if (max < cnt) {
                max = cnt;
            }
            cnt = 0;
        } else {
            cnt++;
        }
    }
    return max;
}
