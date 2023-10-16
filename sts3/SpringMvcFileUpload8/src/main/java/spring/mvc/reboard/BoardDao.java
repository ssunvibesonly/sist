package spring.mvc.reboard;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao implements BoardDaoInter {

	@Autowired
	SqlSession session;
	
	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return session.selectOne("getTotalCountOfReBoard"); //namespace.을 붙여도 되고 안붙여도 된다.
	}

	@Override
	public int getMaxNum() {
		// TODO Auto-generated method stub
		return session.selectOne("MaxNumOfReboard");
	}

	@Override
	public void updateRestep(int regroup, int restep) {
		// TODO Auto-generated method stub
		
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		
		map.put("regroup", regroup);
		map.put("restep", restep);
		
		session.update("UpdateStepOfReBoard",map );
	}

	@Override
	public void insertReboard(BoardDto dto) {
		// TODO Auto-generated method stub
		
		int num=dto.getNum();
		int regroup=dto.getRegroup();
		int restep=dto.getRestep();
		int relevel=dto.getRelevel();
		
		if(num==0)//새글
		{
			regroup=getMaxNum()+1;
			restep=0;
			relevel=0;
			
		}else { //답글
			//같은 그룹중에서 전달받은 restep보다 큰 글들은 모두 +1
			this.updateRestep(regroup, restep); //this를 하는 이유는 updateRestep 메서드 불러오기위한 용도
			
			//전달받은 step과 level모두 1증가
			restep++;
			relevel++;
		}
		
		//바뀐값들을 다시 dto에 담는다.
		dto.setRegroup(regroup);
		dto.setRestep(restep);
		dto.setRelevel(relevel);
		
		//insert
		session.insert("insertOfReboard", dto);
	}

	@Override
	public List<BoardDto> getPagingList(int start, int perpage) {
		// TODO Auto-generated method stub
		
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		map.put("start", start);
		map.put("perpage", perpage);
		
		return session.selectList("SelectPagingOfReboard", map);
	}

}
