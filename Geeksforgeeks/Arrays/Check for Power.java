if (y == 1) return true;     // x^0 = 1
    if (x <= 1) return false;    // handles x = 0 or 1 safely

    while (y % x == 0) {
        y /= x;
    }
    return y == 1;