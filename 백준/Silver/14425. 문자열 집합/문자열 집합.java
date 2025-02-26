import java.io.*;
import java.util.*;

public class Main {
    static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[26]; // 알파벳 소문자 26개
            isEndOfWord = false;
        }
    }

    static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // 문자열 삽입
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a'; // 알파벳을 인덱스로 변환
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isEndOfWord = true; // 문자열의 끝을 표시
        }

        // 문자열 검색
        public boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    return false; // 해당 문자가 없으면 포함되지 않음
                }
                node = node.children[index];
            }
            return node.isEndOfWord; // 마지막 노드가 문자열 끝인지 확인
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // N과 M 입력
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 트라이 초기화
        Trie trie = new Trie();
        
        // 집합 S에 포함된 문자열 입력 및 트라이에 삽입
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            trie.insert(word);
        }
        
        // 검사할 문자열 입력 및 트라이에 포함된 문자열인지 확인
        int count = 0;
        for (int i = 0; i < M; i++) {
            String word = br.readLine();
            if (trie.search(word)) {
                count++;
            }
        }
        
        // 결과 출력
        System.out.println(count);
    }
}
