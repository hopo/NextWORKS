package kr.or.nextit.mber.service.impl;

import java.io.File;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.nextit.attach.service.AttachVo;
import kr.or.nextit.attach.service.impl.AttachMapper;
import kr.or.nextit.mber.service.MberService;
import kr.or.nextit.member.service.MemberSearchVo;
import kr.or.nextit.member.service.MemberVo;

@Service("MberService")
public class MberServiceImpl implements MberService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	// ;프로퍼티즈를 활용하려함
	@Resource(name = "propertyService")
	private Properties propertiesService;

	@Autowired
	private AttachMapper attachMapper;

	@Autowired
	private MberMapper mberMapper;

	@Override
	public MemberVo joinIdCheck(MemberVo params) throws Exception {

		MemberVo result = null;

		// ;에러처리는 서비스임플에서 컨트롤은 전달 데이터 수준으로만.
		try {
			result = mberMapper.selectIdCheck(params);

			if (result != null && params.getMemId().equals(result.getMemId())) {
				result.setResult(false);
				result.setMessage("*** 사용 불가능한 아이디");
			} else {
				result = new MemberVo();
				result.setResult(true);
				result.setMessage("***사용 가능한 아이디");
			}

		} catch (Exception e) {

			e.printStackTrace();

			result = new MemberVo();
			result.setResult(false);
			result.setMessage(e.getMessage());

		}

		return result;
	}

	@Override
	public MemberVo insertMemberItem(MemberVo memberVo, List<Part> attachPart) throws Exception {
		// ;회원 정보를 등록 => memberVo
		mberMapper.insertMemberItem(memberVo);

		// ;첨부파일
		// ;회원 정보를 첨부파일 정리 =>

		try {

			for (Part part : attachPart) {

				// ;파일을 넘겨주지 않았을 경우
				if (part.getSubmittedFileName().isEmpty()) {
					continue;
				}

				AttachVo item = new AttachVo();

				item.setFileGroup("profile");
				item.setFileId(memberVo.getMemId());

				item.setFileType(part.getContentType());
				item.setFileOriginalFileName(part.getSubmittedFileName());
				item.setFileSize(part.getSize());

				item.setFileSavePath("notice");
				item.setFileSaveFileName(memberVo.getMemId());
				item.setFileFlag("Y");
				item.setFileRegUser("test");

				log.debug(">>> item data: {}", item);

				StringBuilder savePath = new StringBuilder();
				savePath.append(propertiesService.getProperty("file.upload.path"));
				savePath.append(File.separator);
				savePath.append(item.getFileSavePath());
				savePath.append(File.separator);
				savePath.append(item.getFileSaveFileName());

				File file = new File(savePath.toString());
				FileUtils.copyToFile(part.getInputStream(), file);

				attachMapper.insertItem(item);

			}

			memberVo.setResult(true);
			memberVo.setMessage("***회원 가입 성공");

		} catch (Exception e) {

			e.printStackTrace();
			memberVo.setResult(false);
			memberVo.setMessage(e.getMessage());

		}

		return memberVo;
	}

	@Override
	public List<MemberVo> selectMemberList(MemberSearchVo memberSearchVo) throws Exception {
		return mberMapper.selectMemberList(memberSearchVo);
	}

	@Override
	public int selectTotalCount(MemberSearchVo memberSearchVo) throws Exception {
		return mberMapper.selectTotalCount(memberSearchVo);
	}
}
