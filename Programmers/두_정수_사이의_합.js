function solution(a, b) {
    var max = 0;
    var min = 0;
    if (a > b ) {
        max = a;
        min = b;
    } else {
        max = b;
        min = a;
    }
    return Math.floor((min + max) * (max - min + 1) / 2)
}
