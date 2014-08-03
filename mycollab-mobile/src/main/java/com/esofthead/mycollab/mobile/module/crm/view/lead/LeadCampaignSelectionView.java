/**
 * 
 */
package com.esofthead.mycollab.mobile.module.crm.view.lead;

import com.esofthead.mycollab.mobile.module.crm.ui.AbstractRelatedItemSelectionView;
import com.esofthead.mycollab.mobile.module.crm.ui.AbstractRelatedListView;
import com.esofthead.mycollab.mobile.module.crm.view.campaign.CampaignListDisplay;
import com.esofthead.mycollab.mobile.ui.AbstractPagedBeanList;
import com.esofthead.mycollab.module.crm.domain.SimpleCampaign;
import com.esofthead.mycollab.module.crm.domain.criteria.CampaignSearchCriteria;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;

/**
 * @author MyCollab Inc.
 * 
 * @since 4.3.1
 */
public class LeadCampaignSelectionView
		extends
		AbstractRelatedItemSelectionView<SimpleCampaign, CampaignSearchCriteria> {

	private static final long serialVersionUID = -3201084210895713763L;

	public LeadCampaignSelectionView(
			AbstractRelatedListView<SimpleCampaign, CampaignSearchCriteria> relatedListView) {
		super("Select Campaigns", relatedListView);
	}

	@Override
	protected void initUI() {
		this.itemList = new CampaignListDisplay();
		this.itemList
				.setRowDisplayHandler(new AbstractPagedBeanList.RowDisplayHandler<SimpleCampaign>() {

					@Override
					public Component generateRow(final SimpleCampaign obj,
							int rowIndex) {
						final SelectableButton b = new SelectableButton(obj
								.getCampaignname());
						if (selections.contains(obj))
							b.select();
						b.addClickListener(new Button.ClickListener() {

							private static final long serialVersionUID = 5889581455599096544L;

							@Override
							public void buttonClick(ClickEvent event) {
								if (b.isSelected())
									selections.add(obj);
								else
									selections.remove(obj);
							}

						});
						return b;
					}
				});
	}

}