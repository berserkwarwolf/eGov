/* eGov suite of products aim to improve the internal efficiency,transparency,
accountability and the service delivery of the government  organizations.

 Copyright (C) <2015>  eGovernments Foundation

 The updated version of eGov suite of products as by eGovernments Foundation
 is available at http://www.egovernments.org

 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program. If not, see http://www.gnu.org/licenses/ or
 http://www.gnu.org/licenses/gpl.html .

 In addition to the terms of the GPL license to be adhered to in using this
 program, the following additional terms are to be complied with:

     1) All versions of this program, verbatim or modified must carry this
        Legal Notice.

     2) Any misrepresentation of the origin of the material is prohibited. It
        is required that all modified versions of this material be marked in
        reasonable ways as different from the original version.

     3) This license does not grant any rights to any user of the program
        with regards to rights under trademark law for use of the trade names
        or trademarks of eGovernments Foundation.

In case of any queries, you can reach eGovernments Foundation at contact@egovernments.org.
 */

package org.egov.mrs.web.controller.masters;

import static org.egov.infra.web.utils.WebUtils.toJSON;

import java.util.List;

import javax.validation.Valid;

import org.egov.mrs.domain.enums.MarriageFeeCriteriaType;
import org.egov.mrs.masters.entity.Fee;
import org.egov.mrs.masters.service.FeeService;
import org.egov.mrs.web.adaptor.FeeJsonAdaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/masters")
public class FeeController {
	private static final String MRG_FEE_CREATE = "fee-create";
	private static final String MRG_FEE_VIEW = "fee-success";
	private static final String MRG_FEE_SEARCH = "fee-search";
	private static final String MRG_FEE_UPDATE = "fee-update";

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private FeeService feeService;

	@RequestMapping(value = "/fee/create", method = RequestMethod.GET)
	public String loadCreateForm(final Model model) {
		model.addAttribute("fee", new Fee());
		return MRG_FEE_CREATE;
	}

	@RequestMapping(value = "/fee/create", method = RequestMethod.POST)
	public String createFee(@Valid @ModelAttribute final Fee fee,
			final BindingResult errors,
			final RedirectAttributes redirectAttributes) {

		if (errors.hasErrors())
			return MRG_FEE_CREATE;
		fee.setFeeType(MarriageFeeCriteriaType.GENERAL);
		feeService.create(fee);
		redirectAttributes.addFlashAttribute("message",
				messageSource.getMessage("msg.fee.create.success", null, null));
		return "redirect:/masters/fee/success/" + fee.getId();

	}

	@RequestMapping(value = "/fee/success/{id}", method = RequestMethod.GET)
	public String viewFee(@PathVariable Long id, final Model model) {
		model.addAttribute("fee", feeService.getFee(id));
		return MRG_FEE_VIEW;
	}

	@RequestMapping(value = "/fee/search/{mode}", method = RequestMethod.GET)
	public String getSearchPage(@PathVariable("mode") final String mode,
			final Model model) {
		model.addAttribute("fee", new Fee());
		return MRG_FEE_SEARCH;
	}

	@RequestMapping(value = "/fee/searchResult/{mode}", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody String searchFeeResult(@PathVariable("mode") final String mode, Model model,
			@ModelAttribute final Fee fee) {
		
		List<Fee> searchResultList = null;
		if(mode.equalsIgnoreCase("edit")){
			searchResultList	= feeService.searchRegistrationFeesWithGeneralType(fee);
		}else{
			searchResultList=  feeService.searchFee(fee);
		}
			String result = new StringBuilder("{ \"data\":")
				.append(toJSON(searchResultList, Fee.class,
						FeeJsonAdaptor.class)).append("}").toString();
		return result;
	}
	@RequestMapping(value = "/fee/edit/{id}", method = RequestMethod.GET)
	public String editFee(@PathVariable("id") Long id, final Model model) {
		model.addAttribute("fee", feeService.getFee(id));
		return MRG_FEE_UPDATE;
	}

	@RequestMapping(value = "/fee/update", method = RequestMethod.POST)
	public String updateFee(@Valid @ModelAttribute final Fee fee,
			final BindingResult errors,
			final RedirectAttributes redirectAttributes) {
		if (errors.hasErrors()) {
			return MRG_FEE_UPDATE;
		}
		feeService.update(fee);
		redirectAttributes.addFlashAttribute("message",
				messageSource.getMessage("msg.fee.update.success", null, null));
		return "redirect:/masters/fee/success/" + fee.getId();
	}
}
