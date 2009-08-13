package org.lamport.tla.toolbox.tool.tlc.ui.preference;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.lamport.tla.toolbox.tool.tlc.ui.TLCUIActivator;
import org.lamport.tla.toolbox.util.IHelpConstants;
import org.lamport.tla.toolbox.util.UIHelper;

/**
 * Preferences for TLC
 * @author Simon Zambrovski
 * @version $Id$
 */
public class TLCPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage
{
    
    /**
     * Constructor
     */
    public TLCPreferencePage()
    {
        super(GRID);
        setPreferenceStore(TLCUIActivator.getDefault().getPreferenceStore());
        setDescription("TLC Model Checker preferences");
    }

    protected Control createContents(Composite parent)
    {
        Control pageControl = super.createContents(parent);
        UIHelper.setHelp(pageControl, IHelpConstants.TLC_PREFERENCE_PAGE);
        return pageControl;
    }

    /**
     * Create field editors
     */
    protected void createFieldEditors()
    {
        addField(new BooleanFieldEditor(ITLCPreferenceConstants.I_TLC_POPUP_ERRORS,
                "&Popup problem window on TLC errors", getFieldEditorParent()));

        addField(new BooleanFieldEditor(ITLCPreferenceConstants.I_TLC_REVALIDATE_ON_MODIFY,
                "&Automatic re-validate TLC model", getFieldEditorParent()));
    }

    public void init(IWorkbench workbench)
    {

    }
}