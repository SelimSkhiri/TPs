package jcanon;


/**
* jcanon/CorbaPlaneStatus.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /home/vpc/xprojects/gaming/canon/src/tn/rnu/enit/ateliercorba/jcanon/jcanon.idl
* lundi 15 octobre 2007 19 h 43 CEST
*/

public class CorbaPlaneStatus implements org.omg.CORBA.portable.IDLEntity
{
  private        int __value;
  private static int __size = 2;
  private static jcanon.CorbaPlaneStatus[] __array = new jcanon.CorbaPlaneStatus [__size];

  public static final int _ALIVE = 0;
  public static final jcanon.CorbaPlaneStatus ALIVE = new jcanon.CorbaPlaneStatus(_ALIVE);
  public static final int _FALLING = 1;
  public static final jcanon.CorbaPlaneStatus FALLING = new jcanon.CorbaPlaneStatus(_FALLING);

  public int value ()
  {
    return __value;
  }

  public static jcanon.CorbaPlaneStatus from_int (int value)
  {
    if (value >= 0 && value < __size)
      return __array[value];
    else
      throw new org.omg.CORBA.BAD_PARAM ();
  }

  protected CorbaPlaneStatus (int value)
  {
    __value = value;
    __array[__value] = this;
  }
} // class CorbaPlaneStatus
