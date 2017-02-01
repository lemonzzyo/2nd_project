package com.hb.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

// DB처리하는 메소드들만 가지고 있는 클래스
public class DAO {

	private SqlSessionTemplate template;

	public SqlSessionTemplate getTemplate() {
		return template;
	}

	public void setTemplate(SqlSessionTemplate template) {
		this.template = template;
	}
	
	public List<VO> getList() {
		List<VO> list=template.selectList("list");
		return list;
	}

	// 모든 제품 검색 DAO
	public List<ProductVO> p_list() {
		List<ProductVO> list = template.selectList("p_list");
		return list;
	}

	// 한가지 물품 검색 DAO
	public ProductVO p_search(String pid) {
		ProductVO pvo = template.selectOne("p_search", pid);
		return pvo;
	}

	// 물품 정보 수정 DAO
	public int p_update(ProductVO pvo) {
		int result = template.update("p_update", pvo);
		return result;
	}

	// 회원 정보 DAO
	public List<MemberVO> userlist() {
		List<MemberVO> list = template.selectList("user_list");
		return list;
	}

	// 특정 회원 정보 검색 DAO
	public MemberVO m_search(String id) {
		MemberVO mvo = template.selectOne("user_search", id);
		return mvo;
	}

	// 특정 회원 블랙 DAO
	public int blackon(String id) {
		int result = template.update("on_black", id);
		return result;
	}

	// 특정 회원 블랙 해제 DAO
	public int blackoff(String id) {
		int result = template.update("off_black", id);
		return result;
	}

	/* 대원이꺼 DAO */

	// 게시물의 수 구하기
	public int getTotalCount() {
		int su = template.selectOne("totalCount");
		return su;
	}

	// list 구하는 메소드
	public List<ProductVO> getList(Map<String, Integer> map) {
		List<ProductVO> list = template.selectList("listall", map);
		return list;
	}

	public ProductVO getView(String pid) {
		ProductVO vo = template.selectOne("view", pid);
		return vo;
	}

	public List<QnaVO> getQna(String pid) {
		List<QnaVO> list = template.selectList("qnalist", pid);
		return list;
	}

	public List<ProductVO> getSearch(String pname) {
		List<ProductVO> list = template.selectList("search", pname);
		return list;
	}

	public List<ProductVO> getNew() {
		List<ProductVO> list = template.selectList("newlist");
		return list;
	}

	public List<ProductVO> getSale() {
		List<ProductVO> list = template.selectList("salelist");
		return list;
	}

	public List<ProductVO> getCategory(String category) {
		List<ProductVO> list = template.selectList("categorylist", category);
		return list;
	}

	public int insertQna(QnaVO vo) {
		int res;
		res = template.insert("insertQna", vo);
		return res;
	}

	public int insertReQna(QnaVO vo) {
		int res = template.insert("insertReQna", vo);
		return res;
	}

	public QnaVO qnaread(String admin_num) {
		QnaVO qvo = template.selectOne("qna_read", admin_num);
		return qvo;
	}
	
	public int insertReply(ReplyVO vo){
		int res = template.insert("replywrite", vo);
		return res;
	}
	
	public List<ReplyVO> r_list() {
		List<ReplyVO> rlist=template.selectList("replylist");
		return rlist;
	}

	/* 누나꺼 DAO */

	// 아이디 중복체크
		public String getIdchk(String id){
			List<MemberVO> list = template.selectList("idchk", id);
			String result = "사용가능 아이디";
			if(list.size()>0){
				result = "다른 아이디를 입력하세요";
			}
			return result;
		}
		
		// 회원가입
		public int memreg(MemberVO vo){
			int result = template.insert("memreg", vo);
			return result;
		}
		
		// 로그인
		public MemberVO login(MemberVO vo){
			MemberVO mem_vo = template.selectOne("login", vo);
			return mem_vo;
		}
		
		// 비밀번호 확인
		public String getPwdchk(MemberVO vo){
			MemberVO mvo = template.selectOne("pwdchk", vo);
			String result="비밀번호 틀렸습니다.";
			if(mvo!=null){
				result = "";
			}
			return result;
		}
		
		// 회원정보 수정
		public int memupdate(MemberVO vo){
			int result = template.update("memupdate", vo);
			return result;
		}
		
		// 회원 탈퇴
		public int memdel(String id){
			int result = template.delete("memdel", id);
			return result;
		}
		
		// 아이디 찾기
		public String idfind(MemberVO vo){
			MemberVO mvo = template.selectOne("idfind", vo);
			String result = "일치하는 정보가 없습니다.";
			if(mvo!=null){
				result = mvo.getName()+"님의 아이디는 "+mvo.getId()+"입니다";
			}
			return result;
		}

		// 비밀번호 찾기
		public String pwdfind(MemberVO vo){
			MemberVO mvo = template.selectOne("pwdfind", vo);
			String result = "일치하는 정보가 없습니다.";
			if(mvo!=null){
				result = mvo.getName()+"님의 비밀번호는 "+mvo.getPwd()+"입니다";
			}
			return result;
		}
		
		// cart에 품목 추가하기
		public int cartadd(CartVO cvo){
			int result = template.insert("cartadd", cvo);
			return result;
		}
		
		
		// cart 선택삭제
		public int cartdel(CartVO cvo){
			int result = template.delete("cartdel", cvo);
			return result;
		}
		
		// cart 전체삭제
		public int cartdelall(String id){
			int result = template.delete("cartdelall", id);
			return result;
		}
		
		// cart에서 아이디.품목 정보 주고 포인트 정보 가져오기
		public CartVO cartone(CartVO cvo){
			CartVO cvo1 = template.selectOne("cartone", cvo);
			
			return cvo1;
		}
		
		// 회원 포인트 업데이트
		public int mempoint(MemberVO vo){
			int result = template.update("mempoint", vo);
			return result;
		}
				
		// 장바구니 구매 후 상품 수량 업데이트
		public int cartprod_update(ProductVO pvo){
			int result = template.update("cartprod_update", pvo);
			return result;
		}
		
		// 장바구니 상품 수량 변경
		public int cartcnt_update(CartVO cvo){
			int result = template.update("cartcnt_update", cvo);
			return result;
		}
		
		
		// 장바구니 총 포인트 합계
		public int pointsum(String id){
			int pointsum = template.selectOne("pointsum", id);
			return pointsum;
		}

		// 장바구니 총 금액 합계
		public int totalsum(String id){
			int totalsum = template.selectOne("totalsum", id);
			return totalsum;
		}
		
		// 아이디별 장바구니 가져오기
		public List<CartVO> cartallbyid(String id){
			List<CartVO> list = template.selectList("cartallbyid", id);
			return list;
		}
		
		
		public int getTotalRecord() {
			int totalRecord = template.selectOne("totalCount");
			return totalRecord;
		}

}
