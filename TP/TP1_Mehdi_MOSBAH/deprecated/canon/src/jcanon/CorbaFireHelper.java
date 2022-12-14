package jcanon;


/**
* jcanon/CorbaFireHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /home/vpc/xprojects/gaming/canon/src/tn/rnu/enit/ateliercorba/jcanon/jcanon.idl
* lundi 15 octobre 2007 19 h 43 CEST
*/

abstract public class CorbaFireHelper
{
  private static String  _id = "IDL:tn.rnu.enit.ateliercorba/jcanon/CorbaFire/CorbaFire:1.0";

  public static void insert (org.omg.CORBA.Any a, jcanon.CorbaFire that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static jcanon.CorbaFire extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [4];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[0] = new org.omg.CORBA.StructMember (
            "player",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[1] = new org.omg.CORBA.StructMember (
            "x",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[2] = new org.omg.CORBA.StructMember (
            "y",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[3] = new org.omg.CORBA.StructMember (
            "mood",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (jcanon.CorbaFireHelper.id (), "CorbaFire", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static jcanon.CorbaFire read (org.omg.CORBA.portable.InputStream istream)
  {
    jcanon.CorbaFire value = new jcanon.CorbaFire ();
    value.player = istream.read_long ();
    value.x = istream.read_long ();
    value.y = istream.read_long ();
    value.mood = istream.read_long ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, jcanon.CorbaFire value)
  {
    ostream.write_long (value.player);
    ostream.write_long (value.x);
    ostream.write_long (value.y);
    ostream.write_long (value.mood);
  }

}
