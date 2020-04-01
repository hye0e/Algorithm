# 👩🏻‍💻백준 알고리즘 공부

> 2577번
* 왜 못풀었나?

각 숫자마다 배열을 선언 하여 각 배열의 크기를 보여주려고 함
일의 자리 숫자 = 숫자 % 10 까지 생각 하지 못하고, 단순히 String 으로 변환하여 을 자를 생각
* 접근법

배열 한개에 각 숫자를 넣어 for 문을 돌려 비교한다.

* 꼭 기억해둬야 할 것 ✨✨

일의 자리 숫자 = 숫자 % 10
***
> 1546번
* 왜 못풀었나?

출력을 소수점으로 출력해야했는데, 단순 int로 생각해서 답이 계속 잘못 출력되었다.
* 접근법

소수점은 double

* ✨꼭 기억해둬야 할 것 ✨

소수점은 double 진짜 단순한 건데 다시 기본부터 공부하자,,,,^^,,,
***
> 4434번
* 왜 못풀었나?

연산의 순서가 잘못되었다.

[내가 짠 코드]
<pre>
<code>
double result = (float) cntOverAng / (float) scoreCnt * 100.0;
sb.append(String.format("%.3f", result));
</code>
</pre>
[정답]           
<pre>
<code>
sb.append(String.format("%.3f", 100.0 * cntOverAng / scoreCnt));
</code>
</pre>

* 접근법

1차원 배열

* ✨ 꼭 기억해둬야 할 것 ✨

입력이 이어져있다고 자꾸 String으로 본 후 형변환을 할 생각을 버리고, 일단 숫자로 입력되면 int 로 하는 습관을 들이자.

***
> 4673번

* 접근법

1. default 가 false 인 boolean 배열 10001 개를 만든다.
2. 셀프넘를 구한다.
3. 셀프넘버면 true로 바꾼다.
4. 셀프넘버가 아닌 것을 출력한다.

* ✨ 꼭 기억해둬야 할 것 ✨

숫자를 구하는 문제에서 String > int 형변환 절대 하지말기

<pre>
<code>
    int temp = num; // 원래 숫자를 임시 변수에 넣기
      while (num > 0) { 
          temp += num % 10; // 각 자리 숫자를 구하기 위해, 일의 자리 숫자 구하기
          num /= 10; // 그 다음자리 숫자를 구하기 위해 원래 숫자를 나누기
      }
</code>
</pre> 

***
> 1065번

* 접근법

1. 100 이하는 무조건 등차 수열인 것을 인지
2. 100 이상만 한수인지 확인 한다.

***
> 10809

* 접근법

1. indexOf() 함수를 이용한다 
   * indexOf(문자): 해당 문자가 존재하면, 해당 위치를 반환하고, 존재하지 않으면 -1 을 반환한다.

[내가 짠 코드]
<pre>
<code>
        String[] inputArr = input.split("");
        int[] intInputArr = new int[inputArr.length];
        int[] outputArr = new int[26];

        for (int i = 0; i < outputArr.length; i++) {
            outputArr[i] = -1;
        }

        for (int i = 0; i < intInputArr.length; i++) {
            intInputArr[i] = inputArr[i].charAt(0) - 97;
        }


        for (int i = 0; i <= 24; i++) {
            boolean firstFlag = false;
            for (int j = 0; j < intInputArr.length; j++) {
                if (intInputArr[j] == i && firstFlag == false) {
                    outputArr[i] = j;
                    firstFlag = true;
                }
            }
        }

        for (int j = 0; j < outputArr.length; j++) {
          if (j != outputArr.length) {
              System.out.print(outputArr[j] + " ");
          } else {
            System.out.print(outputArr[j]);
          }
        }
</code>
</pre>

[정답]
<pre>
<code>
      String input = br.readLine();

        for (char c = 'a'; c <= 'z'; c++) {
            System.out.print(input.indexOf(c) + " ");
        }
</code>
</pre>

***
> 2941
* 접근법

 1. 크로아티아 알파벳 배열을 만든다.
 2. String의 contains 를 이용하여 포함 되어있다면 * 로 치환
 3. * 를 포함한 길이를 리턴
 
* ✨ 꼭 기억해둬야 할 것 ✨
 1. contains 

***
> 2292
* 접근법
 1. 규칙을 찾는다. 
 2. 1 > 1칸
    2 ~ 7 > 2칸
    8 ~ 19 > 3칸
    20 ~ 37 > 4칸
 3. a(n) = a(n - 1) + 6 * (n - 1) (단 n > 1)
    
* 왜 못풀었나?
규칙을 너무 작은 것에 집중했던 것 같다.

***
> 2869
* 접근법
  1. 달팽이가 하루에 올라 갈 수 있는 높이: A - B 
  2. 달팽이는 정상에 오르기 직전엔 떨어지지 않는다. (V - A) 마지막에 A만 오르기 때문에 총 길이에서 빼준 것.
  따라서 하루를 더한 채 시작.
  3. 며칠 = (V - A) / (A - B)
  4. 소수점을 내리 기 때문에 나머지가 있을 경우만 +1 를 해주었고, 아닌 경우는 그냥 출력
  
* ✨ 꼭 기억해둬야 할 것 ✨
    입력의 상한값이 1,000,000,000 으로 long으로 받아야 된다는 점