/*
 * Copyright 2010 Alternate Computing Solutions Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alternatecomputing.jschnizzle.action;

import java.awt.Frame;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JPanel;

import org.jdesktop.swingx.JXHeader;

import com.alternatecomputing.jschnizzle.model.Diagram;
import com.alternatecomputing.jschnizzle.model.DiagramType;
import com.alternatecomputing.jschnizzle.util.UIUtils;

/**
 * Action class to create a new use case diagram
 */
public class CreateUseCaseDiagramAction extends AbstractAction {
	private static final long serialVersionUID = -735047225608582109L;
	private Frame owner;

	/**
	 * constructor
	 *
	 * @param owner frame on which the dialog will be centered
	 */
	public CreateUseCaseDiagramAction(Frame owner) {
		super("New Use Case Diagram", null);
		putValue(SHORT_DESCRIPTION, "Create a new use case diagram");
		this.owner = owner;
	}

	/**
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		JDialog dialog = new JDialog(owner, "Create Use Case Diagram", true);
		Diagram diagram = new Diagram();
		diagram.setType(DiagramType.UseCase);
		JXHeader header = new JXHeader("New Use Case Diagram", "Enter details for the new use case diagram.");
		JPanel panel = UIUtils.createDiagramPanel(header, diagram, dialog, true);
		dialog.add(panel);
		dialog.setSize(600, 400);
		UIUtils.centerComponent(dialog, owner);
		dialog.setVisible(true);
	}
}
