public class Homework {
    public static void main(String[] args) {

        // 21 - Print the highest number
        int x = 25;
        int y = 30;
        int z = 40;

        if (x > y && x > z) {
            System.out.println("*21*" + "  " + x);
        } else if (y > x && y > z) {
            System.out.println("*21*" + "  " + y);
        } else {
            System.out.println("*21*" + "  " + z);
        }

        // 22 - Print the lowest number
        if (x < y && x < z) {
            System.out.println("*22*" + "  " + x);
        } else if (y < x && y < z) {
            System.out.println("*22*" + "  " + y);
        } else {
            System.out.println("*22*" + "  " + z);
        }

        // 23 - if one number is 1
        int a = 2;
        int b = 18;
        int c = 1;

        if (a == 1 || b == 1 || c == 1) {
            System.out.println("*23*" + "  " + true);
        } else {
            System.out.println("*23*" + "  " + false);
        }

        // 24 - exactly two numbers are 2
        if ((a == 2 && b == 2 && c != 2) ||
                (a == 2 && c == 2 && b != 2) ||
                (b == 2 && c == 2 && a != 2)) {
            System.out.println("*24*" + "  " + true);
        } else {
            System.out.println("*24*" + "  " + false);
        }

        // 25 - triangle check
        if (x + y > z && x + z > y && y + z > x) {
            System.out.println("*25*" + "  " + "y=1");
        } else {
            System.out.println("*25*" + "  " + "y=2");
        }

        // 26 - at least one odd number
        if (x % 2 != 0 || y % 2 != 0 || z % 2 != 0) {
            System.out.println("*26*" + "  " + true);
        } else {
            System.out.println("*26*" + "  " + false);
        }

        // 27 - arithmetic progression
        if (2 * y == x + z) {
            System.out.println("*27*" + "  " + true);
        } else {
            System.out.println("*27*" + "  " + false);
        }

        // 28 - geometric progression
        if (y * y == x * z) {
            System.out.println("*28*" + "  " + true);
        } else {
            System.out.println("*28*" + "  " + false);
        }

        // 29 - ascending order
        if (x <= y && x <= z) {
            if (y <= z) {
                System.out.println("*29*" + "  "  + x + " " + y + " " + z);
            } else {
                System.out.println("*29*" + "  " + x + " " + z + " " + y);
            }
        } else if (y <= x && y <= z) {
            if (x <= z) {
                System.out.println("*29*" + "  " + y + " " + x + " " + z);
            } else {
                System.out.println("*29*" + "  "  + y + " " + z + " " + x);
            }
        } else {
            if (x <= y) {
                System.out.println("*29*" + "  " + z + " " + x + " " + y);
            } else {
                System.out.println("*29*" + "  " + z + " " + y + " " + x);
            }
        }

        int x1 = 115;
        int y1 = 120;
        int z1 = 187;
        int w = 200;

        // 30 - descending order
        if (x1 >= y1 && x1 >= z1 && x1 >= w) {
            if (y1 >= z1 && y1 >= w) {
                if (z1 >= w) {
                    System.out.println( "*30*" + "  " + x1 + " " + y1 + " " + z1 + " " + w);
                } else {
                    System.out.println( "*30*" + "  " + x1 + " " + y1 + " " + w + " " + z1);
                }
            } else if (z1 >= y1 && z1 >= w) {
                if (y1 >= w) {
                    System.out.println( "*30*" + "  " + x1 + " " + z1 + " " + y1 + " " + w);
                } else {
                    System.out.println( "*30*" + "  " + x1 + " " + z1 + " " + w + " " + y1);
                }
            } else {
                if (y1 >= z1) {
                    System.out.println( "*30*" + "  " + x1 + " " + w + " " + y1 + " " + z1);
                } else {
                    System.out.println( "*30*" + "  " + x1 + " " + w + " " + z1 + " " + y1);
                }
            }

        } else if (y1 >= x1 && y1 >= z1 && y1 >= w) {
            if (x1 >= z1 && x1 >= w) {
                if (z1 >= w) {
                    System.out.println( "*30*" + "  " + y1 + " " + x1 + " " + z1 + " " + w);
                } else {
                    System.out.println( "*30*" + "  " + y1 + " " + x1 + " " + w + " " + z1);
                }
            } else if (z1 >= x1 && z1 >= w) {
                if (x1 >= w) {
                    System.out.println( "*30*" + "  " + y1 + " " + z1 + " " + x1 + " " + w);
                } else {
                    System.out.println( "*30*" + "  " + y1 + " " + z1 + " " + w + " " + x1);
                }
            } else {
                if (x1 >= z1) {
                    System.out.println( "*30*" + "  " + y1 + " " + w + " " + x1 + " " + z1);
                } else {
                    System.out.println( "*30*" + "  " + y1 + " " + w + " " + z1 + " " + x1);
                }
            }

        } else if (z1 >= x1 && z1 >= y1 && z1 >= w) {
            if (x1 >= y1 && x1 >= w) {
                if (y1 >= w) {
                    System.out.println( "*30*" + "  " + z1 + " " + x1 + " " + y1 + " " + w);
                } else {
                    System.out.println( "*30*" + "  " + z1 + " " + x1 + " " + w + " " + y1);
                }
            } else if (y1 >= x1 && y1 >= w) {
                if (x1 >= w) {
                    System.out.println( "*30*" + "  " + z1 + " " + y1 + " " + x1 + " " + w);
                } else {
                    System.out.println( "*30*" + "  " + z1 + " " + y1 + " " + w + " " + x1);
                }
            } else {
                if (x1 >= y1) {
                    System.out.println( "*30*" + "  " + z1 + " " + w + " " + x1 + " " + y1);
                } else {
                    System.out.println( "*30*" + "  " + z1 + " " + w + " " + y1 + " " + x1);
                }
            }

        } else {
            if (x1 >= y1 && x1 >= z1) {
                if (y1 >= z1) {
                    System.out.println( "*30*" + "  " + w + " " + x1 + " " + y1 + " " + z1);
                } else {
                    System.out.println( "*30*" + "  " + w + " " + x1 + " " + z1 + " " + y1);
                }
            } else if (y1 >= x1 && y1 >= z1) {
                if (x1 >= z1) {
                    System.out.println( "*30*" + "  " + w + " " + y1 + " " + x1 + " " + z1);
                } else {
                    System.out.println( "*30*" + "  " + w + " " + y1 + " " + z1 + " " + x1);
                }
            } else {
                if (x1 >= y1) {
                    System.out.println( "*30*" + "  " + w + " " + z1 + " " + x1 + " " + y1);
                } else {
                    System.out.println( "*30*" + "  " + w + " " + z1 + " " + y1 + " " + x1);
                }
            }

            // 31 - highest number
            if (x1 > y1 && x1 > z1 && x1 > w) {
                System.out.println("*31*" + "  " + x1);
            } else if (y1 > x1 && y1 > z1 && y1 > w) {
                System.out.println("*31*" + "  " + y1);
            } else if (z1 > x1 && z1 > y1 && z1 > w) {
                System.out.println("*31*" + "  " + z1);
            } else {
                System.out.println("*31*" + "  " + w);
            }

            // 32 - lowest number
            if (x1 < y1 && x1 < z1 && x1 < w) {
                System.out.println("*32*" + "  " + x1);
            } else if (y1 < x1 && y1 < z1 && y1 < w) {
                System.out.println("*32*" + "  " + y1);
            } else if (z1 < x1 && z1 < y1 && z1 < w) {
                System.out.println("*32*" + "  " + z1);
            } else {
                System.out.println("*32*" + "  " + w);
            }

            // 33 - If at least one is 1 then True
            if (x1 == 1 || y1 == 1 || z1 == 1 || w == 1) {
                System.out.println("*33*" + "  " + true);
            } else {
                System.out.println("*33*" + "  " + false);
            }

            //34 - if the sum of the two equals to the sum of the other two then true if not false
            if (x1 + y1 == z1 + w || y1 + w == x1 + z1) {
                System.out.println("*34*" + "  " + true);
            } else {
                System.out.println("*34*" + "  " + false);
            }

            //35 - If one is equal to the sum of other three then true if not false
            if (x1 == y1 + z1 + w) {
                System.out.println("*35*" + "  " + true);
            } else if (y1 == x1 + z1 + w) {
                System.out.println("*35*" + "  " + true);
            } else if (z1 == x1 + y1 + w) {
                System.out.println("*35*" + "  " + true);

            } else if (w == x1 + y1 + z1) {
                System.out.println("*35*" + "  " + true);
            } else {
                System.out.println("*35*" + "  " + false);
            }

            //36 - If at least two is odd then 1 if not 0
            if (x1 % 2 != 0 && y1 % 2 != 0) {
                System.out.println("*36*" + "  " + "1");
            } else if (x1 % 2 != 0 && z1 % 2 != 0) {
                System.out.println("*36*" + "  " + "1");
            } else if (x1 % 2 != 0 && w % 2 != 0) {
                System.out.println("*36*" + "  " + "1");
            } else if (y1 % 2 != 0 && z1 % 2 != 0) {
                System.out.println("*36*" + "  " + "1");
            } else if (y1 % 2 != 0 && w % 2 != 0) {
                System.out.println("*36*" + "  " + "1");

            } else if (z1 % 2 != 0 && w % 2 != 0) {
                System.out.println("*36*" + "  " + "1");
            } else {
                System.out.println("*36*" + "  " + "0");
            }

            //37 - Will print true if the numbers include an Arithmetic progression
            if (y1 - x1 == z1 - y1 && z - y == w - z) {
                System.out.println("*37*" + "  " + true);
            } else {
                System.out.println("*37*" + "  " + false);
            }

            //38 - Will print true if the numbers include Geometirc progression
            if (y1 * y1 == x1 * z1 && z1 * z1 == y1 * w) {
                System.out.println("*38*" + "  " + true);
            } else {
                System.out.println("*38*" + "  " + false);
            }

            //39 - In ascending order
            if (x1 <= y1 && x1 <= z1 && x1 <= w) {
                if (y1 <= z1 && y1 <= w) {
                    if (z1 <= w) {
                        System.out.println("*39*" + "  " + x1 + " " + y1 + " " + z1 + " " + w);
                    } else {
                        System.out.println("*39*" + "  " + x1 + " " + y1 + " " + w + " " + z1);
                    }
                } else if (z1 <= y1 && z1 <= w) {
                    if (y1 <= w) {
                        System.out.println("*39*" + "  " + x1 + " " + z1 + " " + y1 + " " + w);
                    } else {
                        System.out.println("*39*" + "  " + x1 + " " + z1 + " " + w + " " + y1);
                    }
                } else {
                    if (y1 <= z1) {
                        System.out.println("*39*" + "  " + x1 + " " + w + " " + y1 + " " + z1);
                    } else {
                        System.out.println("*39*" + "  " + x1 + " " + w + " " + z1 + " " + y1);
                    }
                }

            } else if (y1 <= x1 && y1 <= z1 && y1 <= w) {
                if (x1 <= z1 && x1 <= w) {
                    if (z1 <= w) {
                        System.out.println("*39*" + "  " + y1 + " " + x1 + " " + z1 + " " + w);
                    } else {
                        System.out.println("*39*" + "  " + y1 + " " + x1 + " " + w + " " + z1);
                    }
                } else if (z1 <= x1 && z1 <= w) {
                    if (x1 <= w) {
                        System.out.println("*39*" + "  " + y1 + " " + z1 + " " + x1 + " " + w);
                    } else {
                        System.out.println("*39*" + "  " + y1 + " " + z1 + " " + w + " " + x1);
                    }
                } else {
                    if (x1 <= z1) {
                        System.out.println("*39*" + "  " + y1 + " " + w + " " + x1 + " " + z1);
                    } else {
                        System.out.println("*39*" + "  " + y1 + " " + w + " " + z1 + " " + x1);
                    }
                }

            } else if (z1 <= x1 && z1 <= y1 && z1 <= w) {
                if (x1 <= y1 && x1 <= w) {
                    if (y1 <= w) {
                        System.out.println("*39*" + "  " + z1 + " " + x1 + " " + y1 + " " + w);
                    } else {
                        System.out.println("*39*" + "  " + z1 + " " + x1 + " " + w + " " + y1);
                    }
                } else if (y1 <= x1 && y1 <= w) {
                    if (x1 <= w) {
                        System.out.println("*39*" + "  " + z1 + " " + y1 + " " + x1 + " " + w);
                    } else {
                        System.out.println("*39*" + "  " + z1 + " " + y1 + " " + w + " " + x1);
                    }
                } else {
                    if (x1 <= y1) {
                        System.out.println("*39*" + "  " + z1 + " " + w + " " + x1 + " " + y1);
                    } else {
                        System.out.println("*39*" + "  " + z1 + " " + w + " " + y1 + " " + x1);
                    }
                }

            } else {
                if (x1 <= y1 && x1 <= z1) {
                    if (y1 <= z1) {
                        System.out.println("*39*" + "  " + w + " " + x1 + " " + y1 + " " + z1);
                    } else {
                        System.out.println("*39*" + "  " + w + " " + x1 + " " + z1 + " " + y1);
                    }
                } else if (y1 <= x1 && y1 <= z1) {
                    if (x1 <= z1) {
                        System.out.println("*39*" + "  " + w + " " + y1 + " " + x1 + " " + z1);
                    } else {
                        System.out.println("*39*" + "  " + w + " " + y1 + " " + z1 + " " + x1);
                    }
                } else {
                    if (x1 <= y1) {
                        System.out.println("*39*" + "  " + w + " " + z1 + " " + x1 + " " + y1);
                    } else {
                        System.out.println("*39*" + "  " + w + " " + z1 + " " + y1 + " " + x1);
                    }
                }



            }

            //40 - In descending order
            if (x1 >= y1 && x1 >= z1 && x1 >= w) {
                if (y1 >= z1 && y1 >= w) {
                    if (z1 >= w) {
                        System.out.println("*40*" + "  " + x1 + " " + y1 + " " + z1 + " " + w);
                    } else {
                        System.out.println("*40*" + "  " + x1 + " " + y1 + " " + w + " " + z1);
                    }
                } else if (z1 >= y1 && z1 >= w) {
                    if (y1 >= w) {
                        System.out.println("*40*" + "  " + x1 + " " + z1 + " " + y1 + " " + w);
                    } else {
                        System.out.println("*40*" + "  " + x1 + " " + z1 + " " + w + " " + y1);
                    }
                } else {
                    if (y1 >= z1) {
                        System.out.println("*40*" + "  " + x1 + " " + w + " " + y1 + " " + z1);
                    } else {
                        System.out.println("*40*" + "  " + x1 + " " + w + " " + z1 + " " + y1);
                    }
                }

            } else if (y1 >= x1 && y1 >= z1 && y1 >= w) {
                if (x1 >= z1 && x1 >= w) {
                    if (z1 >= w) {
                        System.out.println("*40*" + "  " + y1 + " " + x1 + " " + z1 + " " + w);
                    } else {
                        System.out.println("*40*" + "  " + y1 + " " + x1 + " " + w + " " + z1);
                    }
                } else if (z1 >= x1 && z1 >= w) {
                    if (x1 >= w) {
                        System.out.println("*40*" + "  " + y1 + " " + z1 + " " + x1 + " " + w);
                    } else {
                        System.out.println("*40*" + "  " + y1 + " " + z1 + " " + w + " " + x1);
                    }
                } else {
                    if (x1 >= z1) {
                        System.out.println("*40*" + "  " + y1 + " " + w + " " + x1 + " " + z1);
                    } else {
                        System.out.println("*40*" + "  " + y1 + " " + w + " " + z1 + " " + x1);
                    }
                }

            } else if (z1 >= x1 && z1 >= y1 && z1 >= w) {
                if (x1 >= y1 && x1 >= w) {
                    if (y1 >= w) {
                        System.out.println("*40*" + "  " + z1 + " " + x1 + " " + y1 + " " + w);
                    } else {
                        System.out.println("*40*" + "  " + z1 + " " + x1 + " " + w + " " + y1);
                    }
                } else if (y1 >= x1 && y1 >= w) {
                    if (x1 >= w) {
                        System.out.println("*40*" + "  " + z1 + " " + y1 + " " + x1 + " " + w);
                    } else {
                        System.out.println("*40*" + "  " + z1 + " " + y1 + " " + w + " " + x1);
                    }
                } else {
                    if (x1 >= y1) {
                        System.out.println("*40*" + "  " + z1 + " " + w + " " + x1 + " " + y1);
                    } else {
                        System.out.println("*40*" + "  " + z1 + " " + w + " " + y1 + " " + x1);
                    }
                }

            } else {
                if (x1 >= y1 && x1 >= z1) {
                    if (y1 >= z1) {
                        System.out.println("*40*" + "  " + w + " " + x1 + " " + y1 + " " + z1);
                    } else {
                        System.out.println("*40*" + "  " + w + " " + x1 + " " + z1 + " " + y1);
                    }
                } else if (y1 >= x1 && y1 >= z1) {
                    if (x1 >= z1) {
                        System.out.println("*40*" + "  " + w + " " + y1 + " " + x1 + " " + z1);
                    } else {
                        System.out.println("*40*" + "  " + w + " " + y1 + " " + z1 + " " + x1);
                    }
                } else {
                    if (x1 >= y1) {
                        System.out.println("*40*" + "  " + w + " " + z1 + " " + x1 + " " + y1);
                    } else {
                        System.out.println("*40*" + "  " + w + " " + z1 + " " + y1 + " " + x1);
                    }
                }



            }

            // Switch case Task
            int day1 = 1;
            int day2 = 2;
            int day3 = 3;
            int day4 = 4;
            int day5 = 5;
            int day6 = 6;
            int day7 = 7;

            switch(day1){
                case 1:
                    System.out.println("Erkushabtia - Dasi enq");
                    break;
                case 2:
                    System.out.println("Ereqshabtia - Dasi chenq");
                    break;
                case 3:
                    System.out.println("Choreqshabtia - Dasi enq");
                    break;
                case 4:
                    System.out.println("Hingshabtia - Dasi chenq");
                    break;
                case 5:
                    System.out.println("Urbata - Dasi enq");
                    break;
                case 6:
                    System.out.println("Shabata - Dasi chenq ");
                    break;
                case 7:
                    System.out.println("Kirakia - Azat or");
                    break;
                default:
                    System.out.println("Tenc or chka");
                    break;
            }
            switch(day2){
                case 1:
                    System.out.println("Erkushabtia - Dasi enq");
                    break;
                case 2:
                    System.out.println("Ereqshabtia - Dasi chenq");
                    break;
                case 3:
                    System.out.println("Choreqshabtia - Dasi enq");
                    break;
                case 4:
                    System.out.println("Hingshabtia - Dasi chenq");
                    break;
                case 5:
                    System.out.println("Urbata - Dasi enq");
                    break;
                case 6:
                    System.out.println("Shabata - Dasi chenq ");
                    break;
                case 7:
                    System.out.println("Kirakia - Azat or");
                    break;
                default:
                    System.out.println("Tenc or chka");
                    break;
            }
            switch(day3){
                case 1:
                    System.out.println("Erkushabtia - Dasi enq");
                    break;
                case 2:
                    System.out.println("Ereqshabtia - Dasi chenq");
                    break;
                case 3:
                    System.out.println("Choreqshabtia - Dasi enq");
                    break;
                case 4:
                    System.out.println("Hingshabtia - Dasi chenq");
                    break;
                case 5:
                    System.out.println("Urbata - Dasi enq");
                    break;
                case 6:
                    System.out.println("Shabata - Dasi chenq ");
                    break;
                case 7:
                    System.out.println("Kirakia - Azat or");
                    break;
                default:
                    System.out.println("Tenc or chka");
                    break;
            }
            switch(day4){
                case 1:
                    System.out.println("Erkushabtia - Dasi enq");
                    break;
                case 2:
                    System.out.println("Ereqshabtia - Dasi chenq");
                    break;
                case 3:
                    System.out.println("Choreqshabtia - Dasi enq");
                    break;
                case 4:
                    System.out.println("Hingshabtia - Dasi chenq");
                    break;
                case 5:
                    System.out.println("Urbata - Dasi enq");
                    break;
                case 6:
                    System.out.println("Shabata - Dasi chenq ");
                    break;
                case 7:
                    System.out.println("Kirakia - Azat or");
                    break;
                default:
                    System.out.println("Tenc or chka");
                    break;
            }
            switch(day5){
                case 1:
                    System.out.println("Erkushabtia - Dasi enq");
                    break;
                case 2:
                    System.out.println("Ereqshabtia - Dasi chenq");
                    break;
                case 3:
                    System.out.println("Choreqshabtia - Dasi enq");
                    break;
                case 4:
                    System.out.println("Hingshabtia - Dasi chenq");
                    break;
                case 5:
                    System.out.println("Urbata - Dasi enq");
                    break;
                case 6:
                    System.out.println("Shabata - Dasi chenq ");
                    break;
                case 7:
                    System.out.println("Kirakia - Azat or");
                    break;
                default:
                    System.out.println("Tenc or chka");
                    break;
            }
            switch(day7){
                case 1:
                    System.out.println("Erkushabtia - Dasi enq");
                    break;
                case 2:
                    System.out.println("Ereqshabtia - Dasi chenq");
                    break;
                case 3:
                    System.out.println("Choreqshabtia - Dasi enq");
                    break;
                case 4:
                    System.out.println("Hingshabtia - Dasi chenq");
                    break;
                case 5:
                    System.out.println("Urbata - Dasi enq");
                    break;
                case 6:
                    System.out.println("Shabata - Dasi chenq ");
                    break;
                case 7:
                    System.out.println("Kirakia - Azat or");
                    break;
                default:
                    System.out.println("Tenc or chka");
                    break;
            }
            








        }
    }
}