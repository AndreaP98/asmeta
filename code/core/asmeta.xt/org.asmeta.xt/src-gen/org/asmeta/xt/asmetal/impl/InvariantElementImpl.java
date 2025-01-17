/**
 * generated by Xtext 2.28.0
 */
package org.asmeta.xt.asmetal.impl;

import java.util.Collection;

import org.asmeta.xt.asmetal.AsmetalPackage;
import org.asmeta.xt.asmetal.Domain;
import org.asmeta.xt.asmetal.InvariantElement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invariant Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.asmeta.xt.asmetal.impl.InvariantElementImpl#getConstrainedName <em>Constrained Name</em>}</li>
 *   <li>{@link org.asmeta.xt.asmetal.impl.InvariantElementImpl#getDomainList <em>Domain List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InvariantElementImpl extends MinimalEObjectImpl.Container implements InvariantElement
{
  /**
   * The default value of the '{@link #getConstrainedName() <em>Constrained Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstrainedName()
   * @generated
   * @ordered
   */
  protected static final String CONSTRAINED_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getConstrainedName() <em>Constrained Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConstrainedName()
   * @generated
   * @ordered
   */
  protected String constrainedName = CONSTRAINED_NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getDomainList() <em>Domain List</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDomainList()
   * @generated
   * @ordered
   */
  protected EList<Domain> domainList;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InvariantElementImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return AsmetalPackage.Literals.INVARIANT_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getConstrainedName()
  {
    return constrainedName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setConstrainedName(String newConstrainedName)
  {
    String oldConstrainedName = constrainedName;
    constrainedName = newConstrainedName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AsmetalPackage.INVARIANT_ELEMENT__CONSTRAINED_NAME, oldConstrainedName, constrainedName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Domain> getDomainList()
  {
    if (domainList == null)
    {
      domainList = new EObjectContainmentEList<Domain>(Domain.class, this, AsmetalPackage.INVARIANT_ELEMENT__DOMAIN_LIST);
    }
    return domainList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case AsmetalPackage.INVARIANT_ELEMENT__DOMAIN_LIST:
        return ((InternalEList<?>)getDomainList()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case AsmetalPackage.INVARIANT_ELEMENT__CONSTRAINED_NAME:
        return getConstrainedName();
      case AsmetalPackage.INVARIANT_ELEMENT__DOMAIN_LIST:
        return getDomainList();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case AsmetalPackage.INVARIANT_ELEMENT__CONSTRAINED_NAME:
        setConstrainedName((String)newValue);
        return;
      case AsmetalPackage.INVARIANT_ELEMENT__DOMAIN_LIST:
        getDomainList().clear();
        getDomainList().addAll((Collection<? extends Domain>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case AsmetalPackage.INVARIANT_ELEMENT__CONSTRAINED_NAME:
        setConstrainedName(CONSTRAINED_NAME_EDEFAULT);
        return;
      case AsmetalPackage.INVARIANT_ELEMENT__DOMAIN_LIST:
        getDomainList().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case AsmetalPackage.INVARIANT_ELEMENT__CONSTRAINED_NAME:
        return CONSTRAINED_NAME_EDEFAULT == null ? constrainedName != null : !CONSTRAINED_NAME_EDEFAULT.equals(constrainedName);
      case AsmetalPackage.INVARIANT_ELEMENT__DOMAIN_LIST:
        return domainList != null && !domainList.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (constrainedName: ");
    result.append(constrainedName);
    result.append(')');
    return result.toString();
  }

} //InvariantElementImpl
