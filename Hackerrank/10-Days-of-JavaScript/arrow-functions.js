function modifyArray(nums) {
    let func = n => n % 2 ? n * 3 : n * 2;
    var newNums = nums.map(func);
    return newNums;
}